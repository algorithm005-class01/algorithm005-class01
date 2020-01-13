# 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
#
# 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
#
# 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
#
# 示例 1:
#
# 输入: [2,4,1], k = 2
# 输出: 2
# 解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
#
#
# 示例 2:
#
# 输入: [3,2,6,5,0,3], k = 2
# 输出: 7
# 解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
#      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
#
# Related Topics 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):

    def max_k_inf(self, prices):
        dp_i_0, dp_i_1 = 0, float('-inf')
        for i in range(len(prices)):
            dp_i_1 = max(dp_i_1, dp_i_0 - prices[i])
            dp_i_0 = max(dp_i_0, dp_i_1 + prices[i])

        return dp_i_0

    def maxProfit(self, k, prices):
        """
        dp[i][k][0 or 1] 表示第i天，交易k 次手上是否持有股票的最大获利金额
        0 表示不持有， 1 表示持有
        dp[i][k][0] = max(dp[i-1][k][0]，  dp[i-1][k][1] + prices[i])
                                          (注意也可以在买入的时候 k-1, 如下)
        dp[i][k][0] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
                                        注意也可以在卖出的时候 k-1, )
        当k很大时会超时
        次交易由买入和卖出构成，至少需要两天。所以说有效的限制 k 应该不超过 n/2，如果超过，就没有约束作用了，相当于 k = +infinity。

        """
        if not prices or len(prices) == 1: return 0
        n = len(prices)

        # 忽略k
        if k > n // 2:
            return self.max_k_inf(prices)
        dp = [[[0, 0] for _ in range(k + 1)] for _ in range(n)]
        for i in range(n):
            for j in range(k, 0, -1):
                if i - 1 == -1:
                    dp[i][j][0] = 0
                    dp[i][j][1] = - prices[0]
                else:
                    dp[i][j][0] = max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i])
                    dp[i][j][1] = max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i])

        return dp[n - 1][k][0]


# leetcode submit region end(Prohibit modification and deletion)
assert Solution().maxProfit(2, [3, 2, 6, 5, 0, 3]) == 7
assert Solution().maxProfit(2, [2, 4, 1]) == 2
assert Solution().maxProfit(2, []) == 0
assert Solution().maxProfit(2, [1]) == 0
