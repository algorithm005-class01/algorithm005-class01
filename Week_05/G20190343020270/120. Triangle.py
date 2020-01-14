# 120. Triangle

# Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

# For example, given the following triangle

# [
#      [2],
#     [3,4],
#    [6,5,7],
#   [4,1,8,3]
# ]
# The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

class Solution(object):
    def minimumTotal(self, triangle):
        """
        :type triangle: List[List[int]]
        :rtype: int
        """
        # 1. brute-force 递归 n层：left or right 2^n
        # DP:
        #  a. 重复性(分治) problem(i,j) = min(sub[i+1, j], sub[i+1,j+1]) + a[i,j] 
        #  b. 定义状态数组 f[i,j]
        #  c. DP 方程 f[i,j] = min(f[i+1, j], f[i+1,j+1]) + a[i,j]
        
        dp = triangle
        for i in range(len(triangle)-2,-1,-1):
            for j in range(len(triangle[i])):
                dp[i][j] += min(dp[i+1][j], dp[i+1][j+1])
        return dp[0][0]