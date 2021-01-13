package data_structures.arrays

object Problem01_07 extends App {

  def countSubarrays(arr: Array[Int]): Array[Int] = {

    val len = arr.length

    def count(v: Int, index: Int, step: Int, acc: Int = 0): Int = {
      if(index >= len || index < 0)
        acc
      else if(v >= arr(index))
        count(v, index+step, step, acc+1)
      else
        acc
    }

    def countRight(v: Int, start: Int, acc: Int = 0): Int = count(v, start, 1, 0)
    def countLeft(v: Int, end: Int, acc: Int = 0): Int = count(v, end, -1, 0)


    val results = new Array[Int](len)

    arr.indices.foreach{ i =>
      results.update(i, countRight(arr(i), i+1) + countLeft(arr(i), i-1) + 1)
    }

    results
  }

  val stdin = scala.io.StdIn
  val arr: Array[Int] = stdin.readLine.split(" ").map(_.trim.toInt)

  val counted = countSubarrays(arr)

  println(s"""Input arr: [${arr.mkString(",")}] subArrayCount: [${counted.mkString(",")}]""")

}
