# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/longest-increasing-subsequence/"""
from typing import List

class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        # dp[i]: 以nums[i]结尾的最长有序序列长度
        # dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)
        if not nums:
            return 0
        length = len(nums)
        if length == 1:
            return 1
        dp = [1] * length
        for i in range(1, length):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)