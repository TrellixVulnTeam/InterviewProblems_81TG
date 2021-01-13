package data_structures.arrays

import scala.runtime.ScalaRunTime.stringOf

object Problem01_08 extends App {

  def printIntervals(input: Array[Array[Int]]): String =
    stringOf(input)


  def sortIntervals(input: Array[Array[Int]]): Array[Array[Int]] =
    input.sortWith((l, r) => l(0) <= r(0))

  def checkForOverlap(l: Array[Int], r: Array[Int]): Boolean =
    if (l(1) < r(0))
      false
    else if (r(1) < l(0))
      false
    else
      true

  def combineIntervals(l: Array[Int], r: Array[Int]): Array[Int] =
    Array[Int](Math.min(l(0), r(1)), Math.max(l(1), r(1)))

  def distance(interval: Array[Int]): Int =
    interval(1) - interval(0)

  def findOverlapDistance(input: Array[Array[Int]]): Int = {

    def helper(remaining: Array[Array[Int]], d: Int, lastMatch: Array[Int]): Int = remaining match {
      case r if r.length > 1 => {
        val current = r(0)
        val next = r(1)
        val oldOverlap = if (lastMatch.isEmpty) current else lastMatch
        val lastMatchDistance = if (lastMatch.isEmpty) 0 else distance(lastMatch)
        if (checkForOverlap(current, next)) {
          val newOverlappedInterval = combineIntervals(oldOverlap, next)
          val newOverlapDistance = distance(newOverlappedInterval)
          helper(r.tail, d + newOverlapDistance - lastMatchDistance, newOverlappedInterval)
        } else {
          helper(r.tail, d, Array.empty)
        }
      }
      case _ => d
    }

    helper(sortIntervals(input), 0, Array.empty)

  }

  val input1 = Array(Array(8, 12), Array(2, 6), Array(7, 10), Array(1, 5))
  val input2 = Array(Array(1, 8), Array(2, 6), Array(11, 12), Array(12, 13))
  val input3 = Array(Array(8, 12), Array(2, 6), Array(7, 10), Array(1, 5), Array(3,4))
  val input4 = Array(Array(8, 12), Array(2, 6), Array(7, 10), Array(1, 5), Array(3,4), Array(4,5))

  assert(findOverlapDistance(input1) == 10)
  assert(findOverlapDistance(input2) == 9)
  assert(findOverlapDistance(input3) == 10)
  assert(findOverlapDistance(input4) == 10)

}
