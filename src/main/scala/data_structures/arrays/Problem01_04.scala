package data_structures.arrays

import scala.collection.mutable

// see https://leetcode.com/problems/count-of-smaller-numbers-after-self/submissions/

object Problem01_04  extends App {

  def bruteForce(arr: Array[Int]): Array[Int] = {
    val length = arr.length
    val answer = new Array[Int](length)

    // Here is the Brute Force Solution: space O(n), time O(n^2)
    arr.indices.foreach { i =>
      answer(i) = arr.slice(i + 1, length).count(e => e < arr(i))
    }
    answer
}



  def findSmallerToRightHelper(arr: Array[Int]): Array[Int] = {

    val length = arr.length
    val answer = new Array[Int](length)

    // Here is a better solution.
    var sorted = Array.emptyIntArray

    Range(length-1, -1, -1).foreach{i =>
      val index = java.util.Arrays.binarySearch(sorted, arr(i))
      sorted = (arr(i) +: sorted).sorted
      answer(i) = if(index < 0) -1*index -1 else index
    }

    answer
  }

  def FindSmallerToRight(arr: Array[Int]): Array[Int] = arr.length match {
    case 0 => Array.emptyIntArray
    case 1 => Array[Int](0)
    case _ => findSmallerToRightHelper(arr)
  }


  val stdin = scala.io.StdIn
  val arr: Array[Int] = stdin.readLine.split(" ").map(_.trim.toInt)
  val smallerToRight = FindSmallerToRight(arr)
  println(s"input: [${arr.mkString(",")}] smallerToRight: [${smallerToRight.mkString(",")}]")
}
