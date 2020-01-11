#
# @lc app=leetcode.cn id=279 lang=python3
#
# [279] 完全平方数
#
# https://leetcode-cn.com/problems/perfect-squares/description/
#
# algorithms
# Medium (51.54%)
# Likes:    275
# Dislikes: 0
# Total Accepted:    31.5K
# Total Submissions: 60K
# Testcase Example:  '12'
#
# 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
#
# 示例 1:
#
# 输入: n = 12
# 输出: 3
# 解释: 12 = 4 + 4 + 4.
#
# 示例 2:
#
# 输入: n = 13
# 输出: 2
# 解释: 13 = 4 + 9.
#
#
import math


# @lc code=start
class Solution:
    def numSquares(self, n: int) -> int:
        squares = [i**2 for i in range(1, int(math.sqrt(n)) + 1)]
        dp = [0] * (n + 1)
        for i in range(1, n + 1):
            if i in squares:
                dp[i] = 1
            else:
                choices = [dp[i - square] for square in squares if i > square]
                dp[i] = 1 + min(choices)
        return dp[-1]


# @lc code=end
