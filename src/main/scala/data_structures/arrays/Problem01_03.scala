package data_structures.arrays

case object MaxSubArraySum {
  import Math.max

  def apply(arr: Array[Int]): Int= {
    var currentSum = 0
    var bestSum = 0

    for(i <- arr.indices) {
      currentSum = max(0, currentSum + arr(i))
      bestSum = max(bestSum, currentSum)
    }

    bestSum
  }

  def withWrapAround(arr: Array[Int]): Int = {
    val sumNoWrap = apply(arr)

    /* ok now if the max is wrapped around we find it like this:

      MaxSubArraySum = TotalSum - MinSubArraySum
      where the MinSubArraySum = -1* (is max of the INVERTED array)!

      MaxSubArraySum = TotalSum + MaxSubArray of inverted matrix
    */

    var totalSum = 0
    var minSubArraySum = 0

    for(i <- arr.indices) {
      totalSum += arr(i)
      arr(i) = -arr(i)
    }
    minSubArraySum = apply(arr)

    // restore the array
    for(i <- arr.indices) {
      arr(i) = -arr(i)
    }

    println(s"Debug: totalSum: $totalSum and minSubArraySum: $minSubArraySum")

    max(sumNoWrap, totalSum+minSubArraySum)

  }
}

object Problem01_03 extends App {
  val stdin = scala.io.StdIn
  val arr: Array[Int] = stdin.readLine.split(" ").map(_.trim.toInt)
  val maxSubArraySum = MaxSubArraySum(arr)
  val maxSubArraySumWithWrap = MaxSubArraySum.withWrapAround(arr)
  println(s"input: [${arr.mkString(",")}] noWrap: $maxSubArraySum withWrap: $maxSubArraySumWithWrap")
}