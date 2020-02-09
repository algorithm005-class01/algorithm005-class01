from typing import List


class Solution:
    def InsertionSort(self, nums: List[int]) -> List[int]:
        length = len(nums)
        for i in range(length):
            preIndex = i - 1
            cur = nums[i]
            while preIndex >= 0 and nums[preIndex] > cur:
                nums[preIndex + 1] = nums[preIndex]
                preIndex -= 1
            nums[preIndex + 1] = cur
        return nums
