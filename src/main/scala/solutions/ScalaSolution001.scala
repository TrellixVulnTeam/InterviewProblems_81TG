package solutions

object ScalaSolution001 {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val numberOfStairs = stdin.readLine.trim.toInt
    val uniqueWays = waysToClimbDynamic(numberOfStairs)

    println(s"For $numberOfStairs stairs there are $uniqueWays them")
  }


  /**
    *  Brute Force recursion --  works fine for  smallish values of n
    */
  def waysToClimbRecursive(numberOfStairs: Int): Long = {
    assert(numberOfStairs > 0)

    def waysToClimbHelper(n: Int): Long = n match {
      case m if m<=1 => 1L
      case _ => waysToClimbHelper(n-1) + waysToClimbHelper(n-2)
    }

    waysToClimbHelper(numberOfStairs)
  }

  /**
    *  A better solutions is to use "Dynamic" Programming to store  previous results
    *  to avoid all the repeated calculations
    */
  def waysToClimbDynamic(numberOfStairs: Int): Long = {
    assert(numberOfStairs > 0)

    val ways = collection.mutable.Map[Int, Long]()
    ways(0) = 0L
    ways(1) = 1L
    ways(2) = 2L

    for {
      n <- 3 to numberOfStairs
    } ways(n) = ways(n - 1) + ways(n-2)

    ways(numberOfStairs)
  }

}


