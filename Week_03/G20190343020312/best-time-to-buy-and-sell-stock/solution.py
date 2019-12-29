class Solution:
    def maxProfit(self, prices):
        profit = 0
        for i in range(1, len(prices)):
            tmp = prices[i] - prices[i-1]
            if tmp > 0:
                profit = profit + tmp
        return profit
