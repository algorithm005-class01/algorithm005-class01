# 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
#
# 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
#
#
# 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
# 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
#
#
# 示例:
#
# 输入: [1,2,3,0,2]
# 输出: 3
# 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
# Related Topics 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def maxProfit0(self, prices):
        """
        dp[i][k][0] = max(dp[i - 1][k][0], dp[i-1][k][1] + prices[i])
        dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i])

        卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
        dp[i][k][0] = max(dp[i - 1][k][0], dp[i-1][k][1] + prices[i])
        // i - 2
        dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 2][k - 1][0] - prices[i])

        k 不限制
        dp[i][0] = max(dp[i - 1][0], dp[i-1][1] + prices[i])
        dp[i][1] = max(dp[i - 1][1], dp[i - 2][0] - prices[i])
        """
        dp_i_0, dp_i_1 = 0, float('-inf')
        dp_pre_0 = 0   # dp[i - 2][0]
        for i in range(len(prices)):
            temp = dp_i_0
            dp_i_0 = max(dp_i_0, dp_i_1 + prices[i])
            dp_i_1 = max(dp_i_1, dp_pre_0 - prices[i])
            dp_pre_0 = temp
        return dp_i_0

    def maxProfit(self, prices):
        """
        dp[i][k][0] = max(dp[i - 1][k][0], dp[i-1][k][1] + prices[i])
        dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i])

        卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
        dp[i][k][0] = max(dp[i - 1][k][0], dp[i-1][k][1] + prices[i])
        // i - 2
        dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 2][k - 1][0] - prices[i])

        k 不限制
        dp[i][0] = max(dp[i - 1][0], dp[i-1][1] + prices[i])
        dp[i][1] = max(dp[i - 1][1], dp[i - 2][0] - prices[i])
        """
        if not prices or len(prices) == 1: return 0

        dp = [[0, 0] for _ in range(len(prices))]
        dp[0][0] = 0
        dp[0][1] = -prices[0]
        for i in range(1, len(prices)):

            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][1], 0 if i - 2 < 0 else dp[i - 2][0] - prices[i])
            # if i == 1:
            #     dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
            # else:
            #     dp[i][1] = max(dp[i - 1][1], dp[i - 2][0] - prices[i])

        return dp[-1][0]



# leetcode submit region end(Prohibit modification and deletion)
assert Solution().maxProfit([1, 2, 3, 0, 2]) == 3
# assert Solution().maxProfit([]) == 0
assert Solution().maxProfit([1,2]) == 1
assert Solution().maxProfit([2,1]) == 0
