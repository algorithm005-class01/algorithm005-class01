# 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
#
# 示例 1:
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
# Related Topics 广度优先搜索 数学 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def numSquares(self, n):
        """
        dp[i] 表示 从0...i 完全平方数之和

        dp[i] = min(dp[i], dp[i - pow(j, 2)] + 1)   j  1 -> int(sqrt(i))
        """
        dp = [i for i in range(n + 1)]
        dp[1] = 1
        for i in range(2, n + 1):
            sqrt = int(pow(i, 0.5))
            for j in range(1, sqrt + 1):
                dp[i] = min(dp[i], dp[i - pow(j, 2)] + 1)
        return dp[-1]

# leetcode submit region end(Prohibit modification and deletion)
Solution().numSquares(2483)
