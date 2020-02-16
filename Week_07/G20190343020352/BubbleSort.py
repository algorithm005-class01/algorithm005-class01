from typing import List


class Solution:
    def BubbleSort(self, nums: List[int]) -> List[int]:
        length = len(nums)
        for i in range(length):
            for j in range(length - 1 - i):
                if nums[j] > nums[j + 1]:
                    temp = nums[j + 1]
                    nums[j + 1] = nums[j]
                    nums[j] = temp
        return nums