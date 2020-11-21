package solutions

object ScalaSolution004 {


  /**
    * This meets the runtime requirement O(n)
    * But it use O(n) space
    */
  def easyWay(i: Array[Int]): Int = {
    val s = i.toSet
    var missingInt = 1
    while(s.contains(missingInt)) missingInt +=1
    missingInt
  }

  def hardWay(i: Array[Int]): Int = {
    var missingIndex = 0
    def missingInt = missingIndex+1

    while(missingIndex < i.length) {
      if (i(missingIndex) == missingInt) {
        missingIndex += 1
      } else {
        val index = i.indexWhere(_ == missingInt)
        if(index != -1) {
          i(index) = i(missingIndex)
          i(missingIndex) = missingInt
          missingIndex += 1
        }
        else return missingInt
      }
    }
    missingInt
  }

  def main(args: Array[String]): Unit = {
    val input1 = Array[Int](3, 4, -1, 1)
    val ans1 = 2

    val input2 = Array[Int](1, 2, 0)
    val ans2 = 3

    val input3 = Array[Int](1, 2, 0, 5, 3, 3, -1, 6)
    val ans3 = 4


    val ans1b = hardWay(input1)
    val ans2b = hardWay(input2)
    val ans3b = hardWay(input3)
    println(s"Hard way answer is: ${ans1b}")
    println(s"Hard way answer is: ${ans2b}")
    println(s"Hard way answer is: ${ans3b}")
    assert(ans1b == ans1)
    assert(ans2b == ans2)
    assert(ans3b == ans3)

  }

}
