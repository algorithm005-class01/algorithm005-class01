# 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
#
# 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
#
# 问总共有多少条不同的路径？
#
#
#
# 例如，上图是一个7 x 3 的网格。有多少可能的路径？
#
# 说明：m 和 n 的值均不超过 100。
#
# 示例 1:
#
# 输入: m = 3, n = 2
# 输出: 3
# 解释:
# 从左上角开始，总共有 3 条路径可以到达右下角。
# 1. 向右 -> 向右 -> 向下
# 2. 向右 -> 向下 -> 向右
# 3. 向下 -> 向右 -> 向右
#
#
# 示例 2:
#
# 输入: m = 7, n = 3
# 输出: 28
# Related Topics 数组 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def uniquePaths(self, m, n):
        """
        dp[i][j] 从i,j 走到右下角的路径总和
        dp[i][j] = dp[i+1][j] + dp[j][+1]
        """
        dp = [[0] * 2 + [1] for _ in range(m)]
        for i in range(n):
            dp[m - 1][i] = 1
        dp[m-1][n-1] = 0

        for i in range(m - 2, -1, -1):
            for j in range(n - 2, -1, -1):
                print(i, j)
                dp[i][j] = dp[i+1][j] + dp[i][j+1]

        for d in dp:
            print(d)

    def uniquePaths(self, m, n):
        # 返过来， 从右下角走到左上角也是一样的
        dp = [[1] * n] + [[1] + [0] * (n - 1) for _ in range(m - 1)]
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for d in dp:
            print(d)

    def uniquePaths(self, m, n):
        # 返过来， 从右下角走到左上角也是一样的
        dp = [1] * n
        for i in range(1, m):
            for j in range(1, n):
                dp[j] = dp[j] + dp[j-1]
        return dp[-1]

# leetcode submit region end(Prohibit modification and deletion)
Solution().uniquePaths(7, 3)
