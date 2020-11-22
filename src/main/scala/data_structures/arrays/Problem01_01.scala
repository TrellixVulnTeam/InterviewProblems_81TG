package data_structures.arrays

case object GetProductOfAllOtherElements {
  def apply(arr: Array[Int]): Array[Int]= {

    /*  Here is how you do it if you can divide!
    val total = arr.product
    arr.map(total / _)
     */
    val length = arr.length
    val left: Array[Int] = Array.fill(length)(1)
    val right: Array[Int]  = Array.fill(length)(1)

    for(i <- arr.indices) {
      if(i > 0) left(i) = left(i-1) * arr(i-1)
      val j = length - i - 1
      if(j < length - 1) right(j) = right(j+1) * arr(j+1)
    }

    left lazyZip right map (_ * _)

  }
}

object Problem01_01 extends App {
  val stdin = scala.io.StdIn
  val arr: Array[Int] = stdin.readLine.split(" ").map(_.trim.toInt)
  val products = GetProductOfAllOtherElements(arr)
  println(s"input: [${arr.mkString(",")}] output: [${products.mkString(",")}]")
}
