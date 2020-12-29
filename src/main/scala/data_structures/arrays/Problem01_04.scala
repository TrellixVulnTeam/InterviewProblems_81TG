package data_structures.arrays

import scala.collection.mutable

object Problem01_04  extends App {

  def bruteForce(arr: Array[Int]): Array[Int] = {
    val length = arr.length
    val answer = new Array[Int](length)

    // Here is the Brute Force Solution: space O(n), time O(n^2)
    arr.indices.foreach(i =>  answer(i) = arr.slice(i + 1, length).filter(e => e < arr(i)).length)
    answer
}



  def findSmallerToRightHelper(arr: Array[Int]): Array[Int] = {

    val length = arr.length
    val answer = new Array[Int](length)

    // Here is a better solution.
    var sorted = Array.emptyIntArray

    Range(length-2, -1, -1).foreach{i =>
      sorted = (arr(i+1) +: sorted).sorted
      answer(i) = -1*java.util.Arrays.binarySearch(sorted, arr(i)) -1
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
