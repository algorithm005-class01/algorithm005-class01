from typing import List


class Solution:
    def SelectionSort(self, nums: List[int]) -> List[int]:
        length = len(nums)
        for i in range(length):
            minIndex = i
            for j in range(i + 1, length):
                if nums[j] < nums[minIndex]:
                    minIndex = j
            temp = nums[i]
            nums[i] = nums[minIndex]
            nums[minIndex] = temp
        return nums