#
# @lc app=leetcode.cn id=63 lang=python3
#
# [63] 不同路径 II
#
# https://leetcode-cn.com/problems/unique-paths-ii/description/
#
# algorithms
# Medium (31.98%)
# Likes:    202
# Dislikes: 0
# Total Accepted:    35K
# Total Submissions: 108.8K
# Testcase Example:  '[[0,0,0],[0,1,0],[0,0,0]]'
#
# 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
#
# 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
#
# 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
#
#
#
# 网格中的障碍物和空位置分别用 1 和 0 来表示。
#
# 说明：m 和 n 的值均不超过 100。
#
# 示例 1:
#
# 输入:
# [
# [0,0,0],
# [0,1,0],
# [0,0,0]
# ]
# 输出: 2
# 解释:
# 3x3 网格的正中间有一个障碍物。
# 从左上角到右下角一共有 2 条不同的路径：
# 1. 向右 -> 向右 -> 向下 -> 向下
# 2. 向下 -> 向下 -> 向右 -> 向右
#
#
#
from typing import List


# @lc code=start
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        dp = [[0 for _ in range(n)] for _ in range(m)]
        
        dp[-1][-1] = 1 if not obstacleGrid[-1][-1] else 0
        for i in range(m - 2, -1, -1):
            dp[i][-1] = 0 if obstacleGrid[i][-1] else dp[i + 1][-1]
        for j in range(n - 2, -1, -1):
            dp[-1][j] = 0 if obstacleGrid[-1][j] else dp[-1][j + 1]

        for i in range(m - 2, -1, -1):
            for j in range(n - 2, -1, -1):
                dp[i][j] = 0 if obstacleGrid[i][j] else dp[i +
                                                           1][j] + dp[i][j + 1]

        return dp[0][0]


# @lc code=end

aa = [[0, 1], [0, 0]]
Solution().uniquePathsWithObstacles(aa)