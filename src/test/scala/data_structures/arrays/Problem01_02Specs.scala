package data_structures.arrays

import org.scalatest.flatspec.AnyFlatSpec

class Problem01_02Specs extends AnyFlatSpec {

  "Find the smallest sorting Window" should "for given test cases" in {

    val input1 = Array(3,7,5,6,9)

    assert(FindSmallestWindowToBeSorted(input1) == (1,3))
  }

}