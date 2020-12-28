package data_structures.arrays


import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Stack

/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without
changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array
[0,3,1,6,2,2,7].
 */

object  LongestIncreasingSubsequence extends App {

  def LISHelper(s: Array[Int]): Array[Int] = {
    case class PileEntry(element: Int, prevPileEntry: Option[PileEntry])
    type Pile = Stack[PileEntry]

    val piles = ListBuffer.empty[Stack[PileEntry]]

    def previousPile(currentPile: Pile): Option[Pile] = {
      if (piles.length > 1) {
        var prevPile = piles.head
        for (pile <- piles.tail) {
          if (pile.top.element == currentPile.top.element) {
            return Some(prevPile)
          }

          prevPile = pile
        }
      }

      None
    }

    for (i <- 0 until s.length) {
      val toAddPile = piles.find(p => p.top.element >= s(i))

      toAddPile match {
        case Some(p) => {
          val prev = previousPile(p)
          prev match {
            case Some(pp) => p.push(PileEntry(s(i), Some(pp.top)))
            case None => p.push(PileEntry(s(i), None))
          }
        }
        case None => {
          val prev = if (piles.isEmpty) None else Some(piles.last.top)
          piles += Stack(PileEntry(s(i), prev))
        }
      }
    }

    // Building LIS by backtracking
    val subSeq = ListBuffer.empty[Int]
    var lastPileEntry: Option[PileEntry] = Some(piles.last.top)
    while (lastPileEntry != None) {
      subSeq += lastPileEntry.get.element
      lastPileEntry = lastPileEntry.get.prevPileEntry
    }

    subSeq.reverse.toArray
  }

  def findLIS(s: Array[Int]): Array[Int] = {
    if(s.length < 2)
      s
    else
      LISHelper(s)
  }

  val test1 = Array(1,4,3)
  println(s"test1 answer: [${findLIS(test1).mkString(",")}]")

  val test2 = Array(1,4,5,2,6)
  println(s"test2 answer: [${findLIS(test2).mkString(",")}]")


}
