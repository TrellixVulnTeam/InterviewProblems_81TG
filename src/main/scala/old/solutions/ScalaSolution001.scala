package solutions

import scala.annotation.tailrec

object ScalaSolution001 {


  def main(args: Array[String]) {
    val k = 17
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


    /*
    Brute force way would involve a nested iteration to check for every pair of numbers.
    This would take O(N^2).
     */
    def bruteForce2(input: Seq[Int]):Boolean = {
      for {
        i <- 0 until input.length - 1
        j <- i + 1 until input.length
      } if (input(i) + input(j) == k) return true

      false
    }

    /*
    Another way is to use a set to remember the numbers we've seen so far. Then for a given number, we can check if
    there is another number that, if added, would sum to k. This would be O(N) since lookups of sets are O(1) each.
     */
    @tailrec
    def onePass(i: Seq[Int], buffer: Set[Int]):Boolean = i.headOption match {
      case None => false
      case Some(n) =>
        if(buffer.contains(k-n))
          true
        else
          onePass(i.tail, buffer + n)
    }

    val ans1:Boolean = bruteForce2(input)
    println(s"Answer is $ans1")

    val ans2:Boolean = onePass(input, Set.empty[Int])
    println(s"Answer is $ans2")
  }
}
