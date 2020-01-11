#
# @lc app=leetcode.cn id=322 lang=python3
#
# [322] 零钱兑换
#
# https://leetcode-cn.com/problems/coin-change/description/
#
# algorithms
# Medium (36.45%)
# Likes:    310
# Dislikes: 0
# Total Accepted:    33.7K
# Total Submissions: 92.1K
# Testcase Example:  '[1,2,5]\n11'
#
# 给定不同面额的硬币 coins 和一个总金额
# amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
#
# 示例 1:
#
# 输入: coins = [1, 2, 5], amount = 11
# 输出: 3
# 解释: 11 = 5 + 5 + 1
#
# 示例 2:
#
# 输入: coins = [2], amount = 3
# 输出: -1
#
# 说明:
# 你可以认为每种硬币的数量是无限的。
#
#
from typing import List


# @lc code=start
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # 动态规划
        # changes 数组记录币值从 0 到 amount 的最小找零方式
        # amount 的最小找零 = (amount-coins[0])\amount-coins[1])...各种找零方式中的最小 + 1

        changes = [0] * (amount + 1)
        for i in range(1, amount + 1):
            if i in coins:
                changes[i] = 1
            else:
                choices = [
                    changes[i - coin] for coin in coins
                    if i > coin and changes[i - coin] != -1
                ]
                changes[i] = 1 + min(choices) if choices else -1
        return changes[-1]


# @lc code=end
coins = [2]
Solution().coinChange(coins, 3)