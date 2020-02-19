package realquestions

/* asked on 2020-02-10
Given a URL with a CVS list of movie info
find the top 10 rated movies
Asked by Tubi
 */

import scala.io.Source
import scala.util.{Failure, Success, Try}

object RealInterviewQuestions001 {

  case  class MovieRecord(name: String, runtime: Double, rating: Double)

  case object MovieRecord {
    def apply(a: Array[String]): MovieRecord = new MovieRecord(a(0), a(1).toDouble,  a(2).toDouble)
  }

  def makeNewTopTen(rawData: Array[String], currentTopTen: Seq[MovieRecord]): Seq[MovieRecord] = {

    val tryNewRecord: Try[MovieRecord] = Try(MovieRecord(rawData(0), rawData(1).toDouble, rawData(2).toDouble))

    tryNewRecord match {
      case Success(nr) => (nr +: currentTopTen).sortWith((l, r) => l.rating > r.rating).take(10)
      case Failure(f) => {
        println(s"Data received: ${rawData.mkString(",")}")
        currentTopTen
      }
    }
  }



  def main(args: Array[String]) {

    val url = "https://gist.githubusercontent.com/CatTail/18695526bd1adcc21219335f23ea5bea/raw/54045ceeae6a508dec86330c072c43be559c233b/movies.csv"

    val rawData = Source.fromURL(url)

    var topTen = Seq.empty[MovieRecord]

    rawData.getLines().foreach{ l =>
      val splitLine = l.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")  //handle , inside of quotes!
      topTen = makeNewTopTen(splitLine, topTen)
    }

    println("The top ten is:\n" + topTen.mkString("\n"))
  }

}

