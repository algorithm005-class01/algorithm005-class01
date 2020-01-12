# 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
#
# 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
#
# 注意你不能在买入股票前卖出股票。
#
# 示例 1:
#
# 输入: [7,1,5,3,6,4]
# 输出: 5
# 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
#     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
#
#
# 示例 2:
#
# 输入: [7,6,4,3,1]
# 输出: 0
# 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
#
# Related Topics 数组 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def maxProfit(self, prices):
        n, profile = len(prices), 0
        for i in range(n):
            for j in range(i + 1, n):
                profile = max(profile, prices[j] - prices[i])

        return profile

    def maxProfit(self, prices):
        minprice, profile = float('inf'), 0
        for i in range(len(prices)):
            minprice = min(minprice, prices[i])
            profile = max(prices[i] - minprice, profile)

        return profile

    def maxProfit(self, prices):
        """
        base case：
            dp[-1][k][0] = dp[i][0][0] = 0
            dp[-1][k][1] = dp[i][0][1] = -infinity

        状态转移方程：
            dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
            dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])

        dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
        dp[i][1][1] = max(dp[i-1][1][1], 0 - prices[i])

        k == 1 ，所以状态可以简化
        状态转移方程：
            dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp[i][1] = max(dp[i-1][1], 0 - prices[i])
        """
        if not prices:
            return 0
        if len(prices) == 1:
            return 0
        dp = [[0, 0]] * len(prices)
        for i in range(len(prices)):
            if i - 1 == -1:
                dp[i][0] = 0
                dp[i][1] = -prices[i]
                continue
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i])
            dp[i][1] = max(dp[i - 1][1], 0 - prices[i])
        for i in dp:
            print(i)
        return dp[len(prices) - 1][0]

    def maxProfit(self, prices):
        dp_i_0, dp_i_1 = 0, float('-inf')
        for i in range(len(prices)):
            dp_i_0 = max(dp_i_0, dp_i_1 + prices[i])
            dp_i_1 = max(dp_i_1, -prices[i])
        return dp_i_0


# leetcode submit reg(i)ion end(Prohibit modification and deletion)
assert Solution().maxProfit([7, 1, 5, 3, 6, 4]) == 5
assert Solution().maxProfit([1, 2, 3, 0, 2]) == 3
assert Solution().maxProfit([]) == 0
