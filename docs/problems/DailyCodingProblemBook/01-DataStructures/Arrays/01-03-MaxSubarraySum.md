# Problem 1.3

Given an array of numbers, find the maximum sum of any contiguous sub-array of
array.  For example, given the array `[34, -50, 42, 14, -5, 86]`, the maximum
sum would be `137`, since we would take elements `42, 14, -5, and 86`.  Given
the array `[-5, -1, -8, -9]`, the maximum sum would be 0, since we would choose
not to take any elements.

Do this in *O(n)* time.

## Follow-up:
What if the elements can wrap around?  For example, given `[8,-1,3,4]`
, return 15, as we choose the numbers `3,4, 8` where 8 is obtained from wrapping
around.

## Hint:

This is a classic problem!  See [Kadane's algorithm](https://en.wikipedia.org/wiki/Maximum_subarray_problem)
This will give the solution to the first part.

For the circular array part look at [this](https://medium.com/@saurav.agg19/maximum-sum-circular-subarray-437e6decd538)





