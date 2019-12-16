package solutions

object ScalaSolution003 {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    println(s"Enter the numberOfStairs: ")
    val numberOfStairs = stdin.readLine.trim.toInt

    println(s"Enter possible valid steps (e.g. 1, 2): ")
    val steps = stdin.readLine.trim.split(",").map(_.toInt).toSet

    val uniqueWays = waysToClimbBonus(numberOfStairs, steps)
    println(s"For $numberOfStairs stairs there are $uniqueWays unique ways to climb")
  }


  /**
    *  Brute Force recursion --  works fine for smallish values of n
    */
  def waysToClimbRecursive(numberOfStairs: Int): Long = {
    assert(numberOfStairs > 0)

    def waysToClimbHelper(n: Int): Int = n match {
      case m if m<=1 => 1
      case m => waysToClimbHelper(m-1) + waysToClimbHelper(m-2)
    }

    waysToClimbHelper(numberOfStairs)
  }

  /**
    *  A better solutions is to use "Dynamic" Programming to store the previous results
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

  /**
    *  A better solutions is to use "Dynamic" Programming to store the previous results
    *  to avoid all the repeated calculations
    */
  def waysToClimbBonus(numberOfStairs: Int, steps: Set[Int] = Set(1,2)): Long = {
    assert(numberOfStairs > 0)
    assert(steps.nonEmpty)

    val biggestStep = steps.max
    val ways = collection.mutable.Map[Int, Long]()

    def waysToClimbHelper(n: Int): Long = n match {
      case m if m<=1 => 1L
      case m => steps.foldLeft(0L)((acc, cur) => acc + waysToClimbHelper(m-cur))
    }

    for(i <- 0 until biggestStep) ways(i) = waysToClimbHelper(i)

    for {
      n <- biggestStep to numberOfStairs
    } ways(n) = steps.foldLeft(0L)((acc, cur) => acc + ways(n-cur))

    ways(numberOfStairs)
  }

}


