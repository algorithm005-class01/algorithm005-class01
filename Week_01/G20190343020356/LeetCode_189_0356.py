# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/rotate-array"""

# 三次反转,时间复杂度O(n), 空间复杂度O(1)
from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        k %= n
        self._swap(nums, 0, n - k - 1)
        self._swap(nums, n - k, n - 1)
        self._swap(nums, 0, n - 1)

    def _swap(self, nums, i, j):
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1


if __name__ == '__main__':
    from pprint import pprint

    nums = [7, 4, 6, 2, 9, 10, 0, 4, 3, 12]
    k = 4
    pprint(nums)
    Solution().rotate(nums, k)
    pprint(nums)
