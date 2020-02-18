# 62. Unique Paths

# A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

# The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

# How many possible unique paths are there?

# Example 1:

# Input: m = 3, n = 2
# Output: 3
# Explanation:
# From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
# 1. Right -> Right -> Down
# 2. Right -> Down -> Right
# 3. Down -> Right -> Right

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # dp = [[0] * (m + 1) for _ in range(n + 1)]
        # dp[1][1] = 1
        # print(dp)
        # for i in range(1, n+1):
        #     for j in range(1, m+1):
        #         dp[i][j] = dp[i - 1][j] + dp[j][i - 1]
        # return dp[n][m]

        dp = [[1]*n] + [[1]+[0] * (n-1) for _ in range(m-1)]
        print(dp)
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        return dp[-1][-1]