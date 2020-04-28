package realquestions

/*
Asked on 4/28/2020 by RailRoad19
 */

object RealInterviewQuestions002 {
  /*
      Implement the mean, median, mode and range methods in Scala Functional
      style with the minimum code necessary to pass the tests.
   */

  // range: the difference between min and max values
  def range(input: Seq[Int]): Double = input.max - input.min

  // mean: the average of the numbers
  def mean(input: Seq[Integer]): Double = {
    val cleaned: Seq[Double] = input.filterNot(_ == null).map(_.toDouble)
    cleaned.sum / cleaned.length
  }

  // median: the middle number in a sorted list - if there are two middle values, return the average of the two
  def median(input: Seq[Int]): Double = {
    val sorted = input.sorted
    if (sorted.length % 2 == 0) {
      val middle = sorted.length / 2
      val low = middle - 1
      val high = middle
      (sorted(low) + sorted(high)) / 2.0
    } else {
      val middle = sorted.length / 2
      sorted(middle)
    }
  }

  // mode: the most commonly occurring number(s)
  def mode(input: Seq[Int]): Array[Int] = {
    val grouped = input.groupBy(i => i).mapValues(_.size)
    val maxSize = grouped.maxBy(_._2)._2
    grouped.filter { case (_, size) => size == maxSize }.keys.toArray.sorted
  }

}
