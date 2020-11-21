package solutions

object ScalaSolution011 {

  case class TimeMap() {

    private var internalMap = Map.empty[Int, Seq[(Int, Int)]]

    def set(key: Int, value: Int, time: Int): Unit = {
      if(internalMap.isDefinedAt(key)) {
        val timeValues = (internalMap(key).filter(_._1 != time) ++ Seq(Tuple2(time, value)).sortBy(_._1))
        internalMap -= key
        internalMap += (key -> timeValues)
      } else {
        internalMap += (key -> Seq((time, value)))
      }
    }

    def get(key: Int, time: Int): Option[Int] = {
      internalMap.get(key) match {
        case None => None
        case Some(values) => values.filter(_._1 <= time).lastOption.map(_._2)
      }
    }
  }

  def main(args: Array[String]): Unit = {

    val test1 = TimeMap()

    test1.set(1, 1, 0)    // set key 1 to value 1 at time 0
    test1.set(1, 2, 2)    // set key 1 to value 2 at time 2
    assert(test1.get(1, 1).contains(1))   // get key 1 at time 1 should be 1
    assert(test1.get(1, 3).contains(2))   // get key 1 at time 3 should be 2

    val test2 = TimeMap()

    test2.set(1, 1, 5)               //set key 1 to value 1 at time 5
    assert(test2.get(1, 0).isEmpty)         //get key 1 at time 0 should be null
    assert(test2.get(1, 10).contains(1))   //get key 1 at time 10 should be 1

  }

}
