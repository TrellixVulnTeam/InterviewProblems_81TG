import bisect


class Solution:
    @staticmethod
    def count_smaller(nums):
        result = []
        sorted_nums = sorted(nums)

        for num in nums:
            i = bisect.bisect_left(sorted_nums, num)
            result.append(i)
            sorted_nums.pop(i)

        return result
