# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/maximal-square/"""
from typing import List


class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0
        m, n = len(matrix), len(matrix[0])
        # dp[i][j] 表示以matrix(i-1, j-1)为右下角的正方形的变长
        # dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
        max_side = 0
        for i in range(1, m + 1):
            for j in range(1, n + 1):
                dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1 if matrix[i - 1][j - 1] == '1' else 0
                if dp[i][j] > max_side:
                    max_side = dp[i][j]
        return max_side * max_side
