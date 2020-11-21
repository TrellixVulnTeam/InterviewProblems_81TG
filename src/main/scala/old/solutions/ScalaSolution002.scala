package solutions


object ScalaSolution002 {

  //This is probably the best way to do it if you are allowed to use division
  def easyWay(input: Seq[Int]): Seq[Int] = {
    val totalProduct = input.product
    input.map(totalProduct/_)
  }

  // This is a stupid way to do if you can't use division
  def bruteForceWay(input: Seq[Int]): Seq[Int] = {
    val outPut = new Array[Int](input.length)
    for(i <- input.indices) {
      var acc = 1
      for(j <- input.indices if j != i) acc *= input(j)
      outPut(i) = acc
    }
    outPut.toList
  }

  /*
 This is a O(n) way to do if you can't use division
  */
  def noDivisionWay(input: Seq[Int]): Seq[Int] = {
    val len = input.length
    val left:Array[Int] = Array.fill[Int](len)(elem = 1)
    val right:Array[Int] = Array.fill[Int](len)(elem = 1)

    for(i <- input.indices) {
      if(i>0) left(i) = left(i-1)*input(i-1)
      val j = len-(i+1)
      if(j+1 < len) right(j) = input(j+1)*right(j+1)
    }

    left.zip(right).map(e => e._1*e._2)
  }

  def main(args: Array[String]) {

    val input1 = Seq(1, 2, 3, 4, 5)
    val output1 = Seq(120, 60, 40, 30, 24)
    // left  = Array[  1,  1,  2, 6, 24]
    // right = Array[120, 60, 20, 5,  1]


    val input2 = Seq(3, 2, 1)
    val output2 = Seq(2, 3, 6)
    // left  =  Array[1, 3, 6]
    // right =  Array[2, 1, 1]

    assert(output1 == easyWay(input1))
    assert(output2 == easyWay(input2))

    assert(output1 == bruteForceWay(input1))
    assert(output2 == bruteForceWay(input2))

    assert(output1 == noDivisionWay(input1))
    assert(output2 == noDivisionWay(input2))
  }
}
