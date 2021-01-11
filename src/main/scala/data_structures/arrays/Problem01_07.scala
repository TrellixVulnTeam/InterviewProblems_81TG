package data_structures.arrays

object Problem01_07 extends App {

  def countSubarrays(arr: Array[Int]): Array[Int] = {



   arr
  }

  val stdin = scala.io.StdIn
  val arr: Array[Int] = stdin.readLine.split(" ").map(_.trim.toInt)

  val counted = countSubarrays(arr)

  println(s"""Input arr: [${arr.mkString(",")}] subArrayCount: [${counted.mkString(",")}]""")

}
