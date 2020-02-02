# 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
#
# 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
#
# 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
#
# 示例 1:
#
# 输入: [7,1,5,3,6,4]
# 输出: 7
# 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
#      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
#
#
# 示例 2:
#
# 输入: [1,2,3,4,5]
# 输出: 4
# 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
#      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
#      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
#
#
# 示例 3:
#
# 输入: [7,6,4,3,1]
# 输出: 0
# 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
# Related Topics 贪心算法 数组


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def maxProfit(self, prices):
        """
        dp[i][k][0,1]
        i 天， k 交易次数， 0 不持有，1 持有
        dp[i][k][0] = max(dp[i-1][k][0], dp[i - 1][k][1] + prices[i])
                          前一天 没持有rest   前一天持有，今天sell
        dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k - 1][0] - prices[i])
                           前一天 持有rest   前一天 没持有，今天buy
        ----------------------------------------------------------------------
        不限交易次数， k 可以忽略
        dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[1])
        dp[i][1] =  max(dp[i - 1][1], dp[i - 1][0] - prices[i])

        """
        if not prices or len(prices) == 1: return 0
        n = len(prices)
        dp = [[0, 0] for _ in range(n)]
        for i in range(n):
            if i - 1 == -1:
                dp[i][0] = 0
                dp[i][1] = - prices[i]
                continue
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])

        return dp[-1][0]

    def maxProfit(self, prices):
        n = len(prices)
        dp_i_0, dp_i_1 = 0, float('-inf')
        for i in range(n):
            dp_i_1 = max(dp_i_1, dp_i_0 - prices[i])
            dp_i_0 = max(dp_i_0, dp_i_1 + prices[i])

        return dp_i_0


# leetcode submit region end(Prohibit modification and deletion)
assert Solution().maxProfit([7, 1, 5, 3, 6, 4]) == 7
assert Solution().maxProfit([1, 2, 3, 4, 5]) == 4
assert Solution().maxProfit([]) == 0
assert Solution().maxProfit([1]) == 0
