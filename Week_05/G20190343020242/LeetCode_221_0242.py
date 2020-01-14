#
# @lc app=leetcode.cn id=221 lang=python3
#
# [221] 最大正方形
#
# https://leetcode-cn.com/problems/maximal-square/description/
#
# algorithms
# Medium (38.65%)
# Likes:    200
# Dislikes: 0
# Total Accepted:    18.4K
# Total Submissions: 47.3K
# Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
#
# 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
#
# 示例:
#
# 输入:
#
# 1 0 1 0 0
# 1 0 1 1 1
# 1 1 1 1 1
# 1 0 0 1 0
#
# 输出: 4
#
#
from typing import List


# @lc code=start
class Solution:
    def maximalSquare_1(self, matrix: List[List[str]]) -> int:
        # 1. 暴力法
        def isSquare(sub_matrix):
            for row in sub_matrix:
                for item in row:
                    if item == '0':
                        return False
            return True

        if not matrix: return 0

        n, m = len(matrix), len(matrix[0])
        d = min(m, n)
        for w in range(d, -1, -1):
            for i in range(n - w + 1):
                for j in range(m - w + 1):
                    sub_matrix = [row[j:j + w] for row in matrix[i:i + w]]
                    if isSquare(sub_matrix):
                        return w * w

    def maximalSquare(self, matrix: List[List[str]]) -> int:
        # 2. 动态规划
        # dp[i][j]表示以 matrix[i][j] 为顶点的最大边长
        if not matrix: return 0

        n, m = len(matrix), len(matrix[0])
        res = 0
        dp = [[0 for _ in range(m + 1)] for _ in range(n + 1)]

        for i in range(1, n + 1):
            for j in range(1, m + 1):
                if matrix[i - 1][j - 1] == '0':
                    dp[i][j] = 0
                else:
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j],
                                   dp[i][j - 1]) + 1
                if dp[i][j]**2 > res:
                    res = dp[i][j]**2
        return res


# @lc code=end
matrix = [["1", "0", "1", "0", "0"], ["1", "0", "1", "1", "1"],
          ["1", "1", "1", "1", "1"], ["1", "0", "0", "1", "0"]]
Solution().maximalSquare(matrix)