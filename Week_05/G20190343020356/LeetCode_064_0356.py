# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/minimum-path-sum/"""
from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0
        # dp[i][j] += min(dp[i][j-1], dp[i-i][j])
        # 初始化边界条件
        m, n = len(grid), len(grid[0])
        for i in range(1, m):
            grid[i][0] += grid[i - 1][0]
        for j in range(1, n):
            grid[0][j] += grid[0][j - 1]
        for i in range(1, m):
            for j in range(1, n):
                grid[i][j] += min(grid[i][j - 1], grid[i - 1][j])
        return grid[m - 1][n - 1]
