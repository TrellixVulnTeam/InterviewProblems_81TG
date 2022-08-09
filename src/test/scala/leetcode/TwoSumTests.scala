package leetcode

import org.scalatest.flatspec.AnyFlatSpec

class TwoSumTests extends AnyFlatSpec {
  "Solution" should "work for given test cases" in  {

    assert(TwoSum.twoSum(Array(2, 7, 11, 15), 9) sameElements Array(0, 1))
    assert(TwoSum.twoSum(Array(3, 2, 4), 6) sameElements Array(1, 2))
    assert(TwoSum.twoSum(Array(3,3), 6) sameElements Array(0, 1))
    assert(TwoSum.twoSum(Array(3,2,3), 6) sameElements Array(0, 2))

  }
}
