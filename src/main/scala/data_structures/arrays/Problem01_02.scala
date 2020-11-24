package data_structures.arrays

case object FindSmallestWindowToBeSorted {
  def apply(arr: Array[Int]): (Int, Int)= {

    /*  Brute force sort the array, look for differences
    val combined = arr.sorted zip arr

    val first = combined.indexWhere{case (l,r) => l != r}
    val last = combined.lastIndexWhere{case (l,r) => l != r}
    (first,last)
     */

    var currentMax = Int.MinValue
    var currentMin = Int.MaxValue
    val length = arr.length
    var rightBound = 0
    var leftBound = length-1

    for(i <- arr.indices) {
      if(currentMax < arr(i)) currentMax = arr(i)
      if(arr(i) < currentMax) rightBound = i

      val j = length - i - 1
      if(currentMin > arr(j)) currentMin = arr(j)
      if(arr(j) > currentMin) leftBound = j

    }

    (leftBound,rightBound)
  }
}

object Problem01_02 extends App {
  val stdin = scala.io.StdIn
  val arr: Array[Int] = stdin.readLine.split(" ").map(_.trim.toInt)
  val window = FindSmallestWindowToBeSorted(arr)
  println(s"input: [${arr.mkString(",")}] output: $window")
}
