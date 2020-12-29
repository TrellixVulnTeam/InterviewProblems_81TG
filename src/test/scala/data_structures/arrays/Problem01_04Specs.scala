package data_structures.arrays

import org.scalatest.flatspec.AnyFlatSpec
import Problem01_04._

import scala.util.Random

class Problem01_04Specs extends AnyFlatSpec {

  "bruteForce and findSmallerToRightHelper" should "work for given test cases" in {
    val testData = Array(3,4,9,6,1)
    val correctAnswer = Array(1,1,2,1,0)

    assert(bruteForce(testData) === correctAnswer)
    assert(findSmallerToRightHelper(testData) === correctAnswer)
  }

  "Given our assumptions findSmallerToRightHelper" should "be faster than bruteForce" in {
    val testLength = 1000000
    val testData = Array.fill(testLength)(Random.nextInt)

    val bruteStartTime = System.nanoTime()
    val bruteAnswer = bruteForce(testData)
    val bruteTotalTime = System.nanoTime() - bruteStartTime

    val optimizedStartTime = System.nanoTime()
    val optimizedAnswer = findSmallerToRightHelper(testData)
    val optimizedTotalTime = System.nanoTime() - optimizedStartTime

    assert(bruteAnswer === optimizedAnswer)
    assert(optimizedTotalTime < bruteTotalTime)
    println(s"Speed-up: ${(bruteTotalTime*1.0)/optimizedTotalTime}")

  }

}


