package data_structures.arrays

import data_structures.arrays.ReverseArray.{reverse1, reverse2, reverse3}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class ReverseArraySpecs extends AnyFlatSpec with Matchers {
  "Rever Array methods" should "work for given test cases" in {
    val input1 = Array("bob", "sally", "tim")
    val input2 = Array(1, 2)
    val input3 = Array(1)
    val input4 = Array(1, 2, 3, 4, 5, 6)

    val expected1 = Array("tim", "sally", "bob")
    val expected2 = Array(2, 1)
    val expected3 = Array(1)
    val expected4 = Array(6, 5, 4, 3, 2, 1)

    expected1 should equal(reverse1(input1))
    expected1 should equal(reverse2(input1))
    expected1 should equal(reverse3(input1))

    expected2 should equal(reverse1(input2))
    expected2 should equal(reverse2(input2))
    expected2 should equal(reverse3(input2))

    expected3 should equal(reverse1(input3))
    expected3 should equal(reverse2(input3))
    expected3 should equal(reverse3(input3))

    expected4 should equal(reverse1(input4))
    expected4 should equal(reverse2(input4))
    expected4 should equal(reverse3(input4))

  }

}
