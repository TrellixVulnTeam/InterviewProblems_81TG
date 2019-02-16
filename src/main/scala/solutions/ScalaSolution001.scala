package solutions

object ScalaSolution001 {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val numberOfStairs = stdin.readLine.trim.toInt
    val uniqueCombos = waysToClimbRecursive(numberOfStairs)

    uniqueCombos.foreach(combo => println(s"${combo.mkString(",")}"))
  }


  /**
    *  Brute Force recursion --  works fine for  smallish values of n
    */
  def waysToClimbRecursive(numberOfStairs: Int): Seq[Seq[Int]] = {
    assert(numberOfStairs > 0)

    def waysToClimbHelper(acc: Seq[Seq[Int]], n: Int): Seq[Seq[Int]] = n match {
      case m if m <= 0 => acc
      case 1 => acc.map(_ ++ Seq(1))
      case 2 => acc.map(_ ++ Seq(2)) ++ acc.map(_ ++ Seq(1, 1))
      case _ => waysToClimbHelper(acc.map(_ ++ Seq(1)), n-1) ++ waysToClimbHelper(acc.map(_ ++ Seq(2)), n-2)
    }

    waysToClimbHelper(Seq(Seq.empty), numberOfStairs)
  }

  /**
    *  A better solutions is to use "Dynamic" Programming to store  previous results
    *  to avoid all the repeated calculations
    */

  import collection.mutable.{Seq => mSeq}
  def waysToClimbDynamic(numberOfStairs: Int): Seq[Seq[Int]] = {
    assert(numberOfStairs > 0)

    val ways = collection.mutable.Map[Int, Seq[mSeq[Int]]]()
    ways(0) = Seq(mSeq.empty)
    ways(1) = Seq(mSeq(1))
    ways(2) = Seq(mSeq(1, 1), mSeq(2))

    for {
      n <- 3 to numberOfStairs
    } ways(n) = ways(n - 1).map(_ ++ mSeq(1)) ++ ways(n-2).map(_ ++ mSeq(2))

    ways(numberOfStairs)
  }

}


