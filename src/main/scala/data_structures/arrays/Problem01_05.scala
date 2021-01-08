package data_structures.arrays

object PairSums extends App {

  def bruteForce(n: Int, arr: Array[Int], k: Int) : Int = {
    val correctSum = for {
      i <- arr.indices
      j <- i+1 until n if arr(i) + arr(j) == k
    } yield (i, j)

    correctSum.length
  }

  def numberOfWays(n: Int, arr: Array[Int], k: Int) : Int = {
    val valueMap = new scala.collection.mutable.HashMap[Int, Int]

    // Make a HashMap that maps arr's values -> their count
    arr.indices.foreach(i => valueMap.update(arr(i), valueMap.getOrElse(arr(i), 0)+1))

    var ways = 0

    arr.indices.foreach{i =>
      val compliment = k - arr(i)
      val count = valueMap.getOrElse(compliment, 0)
      if(count > 0) {
        if(compliment != arr(i))
          ways += count
        else
          ways += (count-1)
        valueMap.update(arr(i), valueMap(arr(i)) -1)
      }
    }

    ways
  }

  val stdin = scala.io.StdIn
  val n: Int = stdin.readLine.trim.toInt
  val k: Int = stdin.readLine.trim.toInt
  val arr: Array[Int] = stdin.readLine.split(" ").map(_.trim.toInt)
  assert(n == arr.length)

  val nWays = numberOfWays(n, arr, k)
  println(s"input: [${arr.mkString(",")}] number of ways: $nWays to sum to k=$k")
}