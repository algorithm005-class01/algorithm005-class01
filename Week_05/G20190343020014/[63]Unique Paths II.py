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
# 说明：m 和 n 的值均不超过 100。
#
# 示例 1:
#
# 输入:
# [
#   [0,0,0],
#   [0,1,0],
#   [0,0,0]
# ]
# 输出: 2
# 解释:
# 3x3 网格的正中间有一个障碍物。
# 从左上角到右下角一共有 2 条不同的路径：
# 1. 向右 -> 向右 -> 向下 -> 向下
# 2. 向下 -> 向下 -> 向右 -> 向右
#
# Related Topics 数组 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def uniquePathsWithObstacles(self, obstacleGrid):
        """
        dp[i][j] = dp[i+1][j] + dp[i][j+1]  if i,j 不是石头
        dp[i][j] = 0   if i,j 是石头
        """
        if not obstacleGrid: return 0
        m = len(obstacleGrid) - 1
        n = len(obstacleGrid[0]) - 1

        dp = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
        for i in range(m, -1, -1):
            for j in range(n, -1, -1):
                if obstacleGrid[i][j] == 1:
                    dp[i][j] = 0
                elif i == m:  # 下边缘
                    y = j
                    dp[i][j] = 1
                    while y < n:
                        if obstacleGrid[i][y + 1] == 1:
                            dp[i][j] = 0
                            break
                        y += 1
                elif j == n:
                    x = i
                    dp[i][j] = 1
                    while x < m:
                        if obstacleGrid[x + 1][j] == 1:
                            dp[i][j] = 0
                            break
                        x += 1
                else:
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1]
        for d in dp:
            print(d)
        return dp[0][0]

    def uniquePathsWithObstacles(self, obstacleGrid):
        m, n = len(obstacleGrid), len(obstacleGrid[0])
        dp = [0 for _ in range(n)]
        dp[0] = 1
        for i in range(0, m):
            for j in range(0, n):
                if obstacleGrid[i][j] == 0:
                    dp[j] = dp[j] + dp[j - 1]
                else:
                    dp[j] = 0
        print(dp)
        return dp[-1]


# leetcode submit region end(Prohibit modification and deletion)
grid = [[0, 0, 0, 0, 0],
        [0, 0, 0, 0, 1],
        [0, 0, 0, 1, 0],
        [0, 0, 1, 0, 0]]

grid = [[0, 0, 0],
        [0, 1, 0],
        [0, 0, 0]]
Solution().uniquePathsWithObstacles([[0, 1]])
Solution().uniquePathsWithObstacles([[1, 0]])
Solution().uniquePathsWithObstacles([[1, 1]])
Solution().uniquePathsWithObstacles([[0, 1, 1]])
Solution().uniquePathsWithObstacles([[0], [1]])
Solution().uniquePathsWithObstacles(grid)
