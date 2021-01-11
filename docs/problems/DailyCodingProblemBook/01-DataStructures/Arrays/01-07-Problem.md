# Problem 1.7

## Contiguous Subarrays

You are given an array arr of `N` integers. For each index `i`, you are required to determine the
number of contiguous subarrays that fulfills the following conditions:

The value at index `i` must be the maximum element in the contiguous subarrays, and these contiguous
subarrays must either start from or end on index `i`.

## Signature

```java
int[] countSubarrays(int[] arr)
```

## Input

Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
Size N is between 1 and 1,000,000

## Output

An array where each index `i` contains an integer denoting the maximum number of contiguous subarrays
of arr[i]

## Examples:

`arr = [3, 4, 1, 6, 2]`
`output = [1, 3, 1, 5, 1]`

### Explanation:

* `index 0` - [3] is the only contiguous subarray that starts (or ends) with 3, and the maximum value in this subarray is 3.
* `index 1` - [4], [3, 4], [4, 1]
* `index 2` - [1]
* `index 3` - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
* `index 4` - [2]

So, the answer for the above input is [1, 3, 1, 5, 1]