# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/jump-game-ii/"""
from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        max_jump = 0
        count = 0
        last_pos = 0
        for i in range(len(nums)):
            max_jump = max(max_jump, i + nums[i])
            # 最后一个位置不需要jump
            if i == last_pos and i != len(nums) - 1:
                last_pos = max_jump
                count += 1
        return count
