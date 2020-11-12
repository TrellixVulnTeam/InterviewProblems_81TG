package realquestions

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import realquestions.RealInterviewQuestions002._


/*
    Implement the mean, median, mode and range methods in Java 8 Functional
    style with the minimum code necessary to pass the tests.
 */
class RealInterviewQuestions002Specs extends AnyFlatSpec {
  "A range " should "have a value of 14" in {
    assert(14 === range(Seq(3, 17, 15, 11, 9)))
  }

  "A mean " should "have a value of 12.5" in {
    assert(12.5 === mean(Seq(13, 19, null, 14, 16, 5, 8)))
  }

  "A median " should "have a value of 6, 13.5" in {
    assert(6 === median(Seq(7, 11, 6, 2, 5)))
    assert(13.5 === median(Seq(13, 18, 14, 16, 5, 8)))
  }

  "A mode " should "have a value of 3, [3, 5]" in {
    Array(3) shouldBe mode(Seq(5, 2, 3, 6, 4, 1, 3))
    Array(3, 5) shouldBe mode(Seq(4, 5, 3, 1, 3, 2, 5, 6))
  }
}



