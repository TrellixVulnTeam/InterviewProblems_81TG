package data_structures.arrays

import scala.collection.immutable.TreeSet

// see https://leetcode.com/problems/count-of-smaller-numbers-after-self/submissions/

object Problem01_04  extends App {

  def findSmallerToRightBruteForce(arr: Array[Int]): Array[Int] = {
    val length = arr.length
    val answer = new Array[Int](length)

    // Here is the Brute Force Solution: space O(n), time O(n^2)
    arr.indices.foreach { i =>
      answer(i) = arr.slice(i + 1, length).count(e => e < arr(i))
    }
    answer
}

  def findSmallerToRightJava(arr: Array[Int]): Array[Int] = {

    // Here is a better solution than Brute Force, this time we use the
    // fast binary search on Arrays from Java Utils!

    val answer = new Array[Int](arr.length)
    var sortedNums = arr.sorted

    def deduplicateIndex(index: Int, arr: Array[Int]): Int = {
      if (index - 1 >= 0 && sortedNums(index) == sortedNums(index - 1))
        deduplicateIndex(index - 1, arr)
      else
        index
    }

    arr.indices.foreach { i =>
      val index = deduplicateIndex(java.util.Arrays.binarySearch(sortedNums, arr(i)), sortedNums)
      answer(i) = index
      sortedNums = sortedNums.patch(index, Nil, 1)
    }

    answer
  }

  def findSmallerToRightScala(nums: Array[Int]): Array[Int] = {

    // this is just a little data case, and index and value holder
    case class KV(idx: Int, value: Int)

    // we define a ordering for the RB Tree that will rule out duplicates
    implicit object KVOrdering extends Ordering[KV] {
      override def compare(x: KV, y: KV): Int = {     //and order them such that larger indexes with equal value are larger in the Tree
        val cmp = Integer.compare(x.value, y.value)   //due to this when we query the number of smaller items they are not included
        if (cmp == 0) Integer.compare(x.idx, y.idx) else cmp
      }
    }

    val (_, answer) = {
      //we add the index to each entry, then do a fold from the right side
      nums.zipWithIndex.map { case (value, idx) => KV(idx, value) }.foldRight((TreeSet.empty[KV], List.empty[Int]))(
        (ele, acc) => {
          val (currentTreeSet: TreeSet[KV], res: List[Int]) = acc
          val nextTreeSet = currentTreeSet + ele //at each iteration add the element to a RB Tree (TreeSet) - there are no duplicates due to the included index
          val numberSmaller = nextTreeSet.size - nextTreeSet.rangeFrom(ele).size //unlike in java .size is O(1) in the Scala implementation
          (nextTreeSet, numberSmaller +: res) //prepend the size info at each step to a list
        })
    }

    answer.toArray
  }



  val stdin = scala.io.StdIn
  val arr: Array[Int] = stdin.readLine.split(" ").map(_.trim.toInt)
  val smallerToRight = findSmallerToRightScala(arr)
  println(s"input: [${arr.mkString(",")}] smallerToRight: [${smallerToRight.mkString(",")}]")
}
