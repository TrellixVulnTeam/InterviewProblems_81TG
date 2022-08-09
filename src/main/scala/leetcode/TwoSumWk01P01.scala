package leetcode

import scala.annotation.tailrec

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.


https://leetcode.com/problems/two-sum


https://www.techinterviewhandbook.org/grind75?difficulty=Hard&difficulty=Easy&difficulty=Medium&weeks=13&hours=12
Week 1 Problem 1

 */

object TwoSum {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {

    val numsLength = nums.length

    @tailrec
    def calcRightIndex(rightTarget: Int, index: Int): Option[Int] = {
      if(index >= numsLength)
        None
      else if(nums(index) == rightTarget)
        Some(index)
      else
        calcRightIndex(rightTarget, index+1)
    }

    var leftIndex = -1
    var rightIndex: Option[Int] = None

    while(rightIndex.isEmpty) {
      leftIndex = leftIndex+1
      val leftValue = nums(leftIndex)
      rightIndex = calcRightIndex(target-leftValue, leftIndex+1)
    }

    Array(leftIndex, rightIndex.get)
  }

}
