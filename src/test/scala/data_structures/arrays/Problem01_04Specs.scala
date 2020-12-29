package data_structures.arrays

import org.scalatest.flatspec.AnyFlatSpec
import Problem01_04._

import scala.io.Source
import scala.util.Random

class Problem01_04Specs extends AnyFlatSpec {

  "bruteForce and findSmallerToRightHelper" should "work for given test cases" in {
    val testData1 = Array(3,4,9,6,1)
    val correctAnswer1 = Array(1,1,2,1,0)

    assert(bruteForce(testData1) === correctAnswer1)
    assert(findSmallerToRightHelper(testData1) === correctAnswer1)

    val testData2 = Array(-1, -1)
    val correctAnswer2 = Array(0,0)

    assert(bruteForce(testData2) === correctAnswer2)
    assert(findSmallerToRightHelper(testData2) === correctAnswer2)

    val testData3 = Array(26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41)
    val correctAnswer3 = Array(10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0)

    assert(bruteForce(testData3) === correctAnswer3)
    assert(findSmallerToRightHelper(testData3) === correctAnswer3)
  }

  "findSmallerToRightHelper" should "work for given big test case" in {
    val source = Source.fromFile("src/test/scala/data_structures/arrays/Problem01_04_TestData.txt")
    var listOfData = List.empty[Int]
    for(line <- source.getLines())
      listOfData = line.toInt +: listOfData
    source.close()

    val testData1 = listOfData.reverse.toArray
    println(s"Number of test cases: ${testData1.length}")
    val results1 = bruteForce(testData1)
    val results2 = findSmallerToRightHelper(testData1)
    assert(results1(0) == 12469)
    assert(results1(1) == 6652)
    assert(results1(2) == 8255)
    assert(results1(3) == 3153)
    assert(results2 === results1)
  }

  "Given our assumptions findSmallerToRightHelper" should "be faster than bruteForce" in {
    val testLength = 500000
    val testData = Array.fill(testLength)(Random.nextInt)

    val bruteStartTime = System.nanoTime()
    val bruteAnswer = bruteForce(testData)
    val bruteTotalTime = System.nanoTime() - bruteStartTime

    val optimizedStartTime = System.nanoTime()
    val optimizedAnswer = findSmallerToRightHelper(testData)
    val optimizedTotalTime = System.nanoTime() - optimizedStartTime

    //assert(bruteAnswer === optimizedAnswer)
    assert(optimizedTotalTime < bruteTotalTime)
    println(s"Speed-up: ${(bruteTotalTime*1.0)/optimizedTotalTime}")

  }

}


