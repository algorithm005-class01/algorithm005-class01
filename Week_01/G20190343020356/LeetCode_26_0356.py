# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/"""
from typing import List


class Solution:
    # 快慢指针实现
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 0  # 慢指针
        j = 1  # 快指针
        while j < len(nums):
            if nums[i] != nums[j]:
                i += 1
                nums[i] = nums[j]
            j += 1
        return i + 1

    # Python Set 实现, 浪费O(n)空间
    def removeDuplicatesWithSet(self, nums):
        nums_set = set(nums)
        length = len(nums_set)
        nums[:length - 1] = nums_set
        return length


if __name__ == '__main__':
    nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
    print(nums[:Solution().removeDuplicates(nums)])
    # print(nums[:Solution().removeDuplicatesWithSet(nums)])
