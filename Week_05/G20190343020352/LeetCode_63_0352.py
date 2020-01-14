from typing import List


class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        if obstacleGrid[0][0] == 1:
            return 0
        width = len(obstacleGrid[0])
        dp = [0] * width
        dp[0] = 1
        for row in obstacleGrid:
            for j in range(width):
                if row[j] == 1:
                    dp[j] = 0
                elif j > 0:
                    dp[j] += dp[j - 1]
        return dp[width - 1]


if __name__ == '__main__':
    pass

