package leetcode

import org.scalatest.flatspec.AnyFlatSpec

class Problem01_01Specs extends AnyFlatSpec {
  "Solution" should "work for given test cases" in  {
    val restaurants = Array(
      Array(1,4,1,40,10), Array(2,8,0,50,5), Array(3,8,1,30,4), Array(4,10,0,10,3), Array(5,1,1,15,1))
    val veganFriendly = 1
    val maxPrice = 50
    val maxDistance = 10

    val results = Solution1333.filterRestaurants(restaurants, veganFriendly, maxPrice, maxDistance)

    assert(results == List(3,1,5))
  }
}