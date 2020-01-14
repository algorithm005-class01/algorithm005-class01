#
# @lc app=leetcode.cn id=121 lang=python3
#
# [121] 买卖股票的最佳时机
#
# https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/description/
#
# algorithms
# Easy (51.59%)
# Likes:    662
# Dislikes: 0
# Total Accepted:    107.2K
# Total Submissions: 207.2K
# Testcase Example:  '[7,1,5,3,6,4]'
#
# 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
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
# ⁠    注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
#
#
# 示例 2:
#
# 输入: [7,6,4,3,1]
# 输出: 0
# 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
#
#
#

from typing import List


# @lc code=start
class Solution:
    def maxProfit_3(self, prices: List[int]) -> int:
        # 1. 暴力法，两层遍历
        res = 0
        n = len(prices)
        for i in range(n - 1):
            for j in range(i + 1, n):
                profit = prices[j] - prices[i]
                if profit > res:
                    res = profit
        return res

    def maxProfit_2(self, prices: List[int]) -> int:
        # 2. 动态规划：
        # dp[i] 表示 prices[:i] 子序列最大利润 = max(dp[i-1], prices[i]-之前的最低价格)
        if not prices or len(prices)==1:
            return 0

        dp = [0] * len(prices)
        min_price, res = prices[0], 0
        for i in range(1, len(prices)):
            min_price = min(min_price, prices[i - 1])
            dp[i] = max(dp[i - 1], prices[i] - min_price)
            res = max(dp[i], res)
        return res


    def maxProfit(self, prices: List[int]) -> int:
        # 3. 简化版本
        min_price, max_profit = float('inf'), 0
        for p in prices:
            if p < min_price:
                min_price = p
            elif p - min_price > max_profit:
                max_profit = p - min_price
        return max_profit

# @lc code=end
