package solutions

import scala.annotation.tailrec

object ScalaSolution010 {


  def main(args: Array[String]) {
    val k = 25
    val input = Seq(10, 15, 3, 7)

    def bruteForce(input: Seq[Int]):Boolean = {
      val len = input.length
      var ans = false
      var i = 0
      var j = 1

      while(i < len && j < len && !ans) {
        if (input(i) + input(j) == k)
          ans = true
        else {
          i += 1
          j += 2
        }
      }
      ans
    }


    def bruteForce2(input: Seq[Int]):Boolean = {
      import scala.util.control.Breaks._
      var ans = false
      breakable {
         for (i <- 0 until input.length - 1) {
           for (j <- i + 1 until input.length)
             if (input(i) + input(j) == k) {
               ans = true
               break
             }
         }
       }
      ans
    }

    @tailrec
    def better(i: Seq[Int], buffer: Set[Int]):Boolean = i.headOption match {
      case None => false
      case Some(n) => if(buffer.contains(k-n)) true
      else better(i.tail, buffer + n)
    }

    val ans1:Boolean = bruteForce(input)
    println(s"Answer is $ans1")

    val ans2:Boolean = better(input, Set.empty[Int])
    println(s"Answer is $ans2")
  }
}
