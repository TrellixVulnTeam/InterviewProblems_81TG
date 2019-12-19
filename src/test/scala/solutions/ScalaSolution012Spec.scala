package solutions

import org.scalatest._
import ScalaSolution012._

class ScalaSolution012Spec extends FlatSpec with Matchers {

  "The waysToClimbRecursive" should "at least work for small numbers" in {

    a [AssertionError] should be thrownBy {
      waysToClimbRecursive(0)
    }

    assert(waysToClimbRecursive(1) === 1L)
    assert(waysToClimbRecursive(2) === 2L)
    assert(waysToClimbRecursive(3) === 3L)
    assert(waysToClimbRecursive(4) === 5L)
    assert(waysToClimbRecursive(5) === 8L)
    assert(waysToClimbRecursive(6) === 13L)
    // this will fail!
    // assert(waysToClimbRecursive(100) === 13)
  }

  "The waysToClimbDynamic" should "work" in {

    a [AssertionError] should be thrownBy {
      waysToClimbRecursive(0)
    }

    assert(waysToClimbDynamic(1) === 1L)
    assert(waysToClimbDynamic(2) === 2L)
    assert(waysToClimbDynamic(3) === 3L)
    assert(waysToClimbDynamic(4) === 5L)
    assert(waysToClimbDynamic(5) === 8L)
    assert(waysToClimbDynamic(6) === 13L)
    assert(waysToClimbDynamic(100) === 1298777728820984005L)
  }

  "The waysToClimbBonus" should "work" in {

    a [AssertionError] should be thrownBy {
      waysToClimbBonus(0)
    }

    assert(waysToClimbBonus(1) === 1L)
    assert(waysToClimbBonus(2) === 2L)
    assert(waysToClimbBonus(4) === 5L)
    assert(waysToClimbBonus(5) === 8L)
    assert(waysToClimbBonus(6) === 13L)
    assert(waysToClimbBonus(100) === 1298777728820984005L)

    assert(waysToClimbBonus(10, Set(1)) === 1L)
    assert(waysToClimbBonus(10, Set(2)) === 1L)
  }

}
