# 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
#
# 说明：每次只能向下或者向右移动一步。
#
# 示例:
#
# 输入:
# [
#   [1,3,1],
#  [1,5,1],
#  [4,2,1]
# ]
# 输出: 7
# 解释: 因为路径 1→3→1→1→1 的总和最小。
#
# Related Topics 数组 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def minPathSum(self, grid):
        m = len(grid)
        n = len(grid[0])
        dp = [[float('inf') for _ in range(n)] for _ in range(m)]
        dp[0][0] = grid[0][0]
        for i in range(m):
            for j in range(n):
                if i == 0 and j > 0:
                    dp[i][j] = dp[i][j - 1] + + grid[i][j]
                if j == 0 and i > 0:
                    dp[i][j] = dp[i - 1][j] + grid[i][j]
                elif i > 0 and j > 0:
                    dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        for d in dp:
            print(d)
        return dp[-1][-1]

    def minPathSum(self, grid):
        """
         dp(j)=grid(i,j)+min(dp(j),dp(j+1))
        """
        m = len(grid)
        n = len(grid[0])
        x, y = m - 1, n - 1  # x:下边界， y 右边界
        dp = [[float('inf') for _ in range(n)] for _ in range(m)]
        for i in range(x, -1, -1):
            for j in range(y, -1, -1):
                if i == x and j != y:  # 下底
                    dp[i][j] = grid[i][j] + dp[i][j + 1]
                elif j == y and i != x:  # 右边界
                    dp[i][j] = grid[i][j] + dp[i + 1][j]
                elif i != x and j != y:
                    dp[i][j] = min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j]
                else:
                    dp[i][j] = grid[i][j]
        print(dp)
        return dp[0][0]

    def minPathSum(self, grid):
        """原数组修改
         dp(j)=grid(i,j)+min(dp(j),dp(j+1))
        """
        x, y = len(grid) - 1, len(grid[0]) - 1  # x:下边界， y 右边界

        for i in range(x, -1, -1):
            for j in range(y, -1, -1):
                if i == x and j != y:  # 下底
                    grid[i][j] = grid[i][j] + grid[i][j + 1]
                elif j == y and i != x:  # 右边界
                    grid[i][j] = grid[i][j] + grid[i + 1][j]
                elif i != x and j != y:
                    grid[i][j] = min(grid[i + 1][j], grid[i][j + 1]) + grid[i][j]
                else:
                    grid[i][j] = grid[i][j]
        print(grid)
        return grid[0][0]

    def minPathSum(self, grid):
        """
            使用一维数组

        """
        x, y = len(grid) - 1, len(grid[0]) - 1  # x:下边界， y 右边界
        dp = [0 for _ in range(y + 1)]

        for i in range(x, -1, -1):
            for j in range(y, -1, -1):
                if i == x and j != y:  # 下底
                    dp[j] = grid[i][j] + dp[j + 1]
                elif j == y and i != x:  # 右边界
                    dp[j] = grid[i][j] + dp[j]
                elif i != x and j != y:
                    grid[i][j] = min(dp[j], dp[j + 1]) + grid[i][j]
                else:
                    dp[j] = grid[i][j]
        print(dp)
        return dp[0]


# leetcode submit region end(Prohibit modification and deletion)
grid = [[1,2],[1,1]]
Solution().minPathSum(grid)
