package data_structures.arrays

import org.scalatest.flatspec.AnyFlatSpec

class Problem01_01Specs extends AnyFlatSpec {

  "Get Product of All Other Elements" should "for given test cases" in {

    val input1 = Array(1,2,3,4,5)
    val input2 = Array(3,2,1)

    assert(GetProductOfAllOtherElements(input1) sameElements Array(120, 60, 40, 30, 24))
    assert(GetProductOfAllOtherElements(input2) sameElements Array(2, 3, 6))
  }

}
