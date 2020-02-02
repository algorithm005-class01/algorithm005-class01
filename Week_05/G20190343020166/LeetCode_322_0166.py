"""322. 零钱兑换

给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1
说明:
你可以认为每种硬币的数量是无限的。
"""


class Solution(object):

    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int

        1. dp[i]: 代表凑成金额 i 时，需要的最少硬币数量

        2. dp table 填充元素 amount+1, 由于硬币数量最多位 amount(都用1元)，所以填充 amount+1 ，等于与正无穷，便于后续比较时，获得最小值

        3. 金额为 0 时，需要 0 个硬币

        对于每一个目标金额 i，我们遍历所有可能硬币coins金额，从中选取一个，因为 dp[i] 来自 dp[i-coin] + 1(1代表从coins中选一个)，从满足条件的选项中取最小值

        """
        dp = [amount + 1] * (amount + 1)
        dp[0] = 0
        for i in range(1, amount + 1):
            for coin in coins:
                if i - coin < 0:
                    continue
                dp[i] = min(dp[i], dp[i - coin] + 1)
        return -1 if dp[amount] == amount + 1 else dp[amount]
