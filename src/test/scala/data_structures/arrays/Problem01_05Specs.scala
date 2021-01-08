package data_structures.arrays

import data_structures.arrays.Problem1_05._
import org.scalatest.flatspec.AnyFlatSpec

class Problem01_05Specs extends AnyFlatSpec {

  "numberOfWays" should "work for given test cases" in {

    val testArray1 = Array(1, 2, 3, 4, 3)
    assert(bruteForce(5, testArray1, 6) == 2)
    assert(numberOfWays(5, testArray1, 6) == 2)

    val testArray2 = Array(1, 5, 3, 3, 3)
    assert(bruteForce(5, testArray2, 6) == 4)
    assert(numberOfWays(5, testArray2, 6) == 4)
  }

}
