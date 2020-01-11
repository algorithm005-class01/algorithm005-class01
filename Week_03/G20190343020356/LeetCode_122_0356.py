# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/"""
from typing import List


# 贪心算法: 每一步做出当时看起来最佳的选择,寄做出所有局部最优解希望找到全局最优解
# 仅可以用于计算，但计算的过程并不是真正交易的过程，但可以用贪心算法计算题目要求的最大利润
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices or len(prices) == 1:
            return 0
        res = 0
        for i in range(1, len(prices)):
            if prices[i] > prices[i - 1]:
                res += prices[i] - prices[i - 1]
        return res
