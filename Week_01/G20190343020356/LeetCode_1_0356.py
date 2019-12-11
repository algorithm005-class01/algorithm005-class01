# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/two-sum/"""

# HASH解法: 用dict用来作hash
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dictmap = {}
        for i, n in enumerate(nums):
            if n in dictmap:
                return [dictmap[n], i]
            dictmap[target - n] = i
        return []


if __name__ == '__main__':
    nums = [1, 3, 5, 8]
    target = 8
    print(Solution().twoSum(nums, target))
