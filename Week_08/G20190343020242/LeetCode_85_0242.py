#
# @lc app=leetcode.cn id=85 lang=python3
#
# [85] 最大矩形
#
# https://leetcode-cn.com/problems/maximal-rectangle/description/
#
# algorithms
# Hard (43.18%)
# Likes:    288
# Dislikes: 0
# Total Accepted:    15.7K
# Total Submissions: 35.9K
# Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
#
# 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
#
# 示例:
#
# 输入:
# [
# ⁠ ["1","0","1","0","0"],
# ⁠ ["1","0","1","1","1"],
# ⁠ ["1","1","1","1","1"],
# ⁠ ["1","0","0","1","0"]
# ]
# 输出: 6
#
#
from typing import List


# @lc code=start
class Solution:

    def maximalRectangle_1(self, matrix: List[List[str]]) -> int:
        # 1. 栈：LeetCode-84 的解, O(N*M^2)
        # 循环每一行时，heights 表示在该行处每列上 1 的高度
        ans = 0
        if not matrix or not matrix[0]:
            return ans

        heights = [0] * (len(matrix[0]) + 1)
        for i in range(len(matrix)):
            stack = [-1]
            for j in range(len(heights)):
                heights[j] = heights[j] + 1 if j < len(matrix[0]) and matrix[i][j] == '1' else 0
                while heights[j] < heights[stack[-1]]:
                    h = heights[stack.pop()]
                    w = j - stack[-1] - 1
                    ans = max(ans, h * w)
                else:
                    stack.append(j)
        return ans

    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        # 2. dp[i][j] 表示 j 左边 "1" 的长度
        # FIXME: 超时
        ans = 0
        dp = [[0] * len(matrix[0]) for _ in range(len(matrix))]
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == '0':
                    continue
                width = dp[i][j] = dp[i][j - 1] + 1 if j else 1

                for k in range(i, -1, -1):
                    width = min(width, dp[k][j])
                    ans = max(ans, width * (i - k + 1))

        return ans


# @lc code=end

matrix = [["1", "0", "1", "0", "0"], ["1", "0", "1", "1", "1"], ["1", "1", "1", "1", "1"],
          ["1", "0", "0", "1", "0"]]

Solution().maximalRectangle(matrix)
