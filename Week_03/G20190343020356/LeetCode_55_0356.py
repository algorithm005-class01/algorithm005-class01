# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/jump-game/"""
from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_jump = 0
        for i in range(len(nums)):
            if i <= max_jump:
                max_jump = max(max_jump, i + nums[i])
            if max_jump >= len(nums) - 1:
                return True
        return False
