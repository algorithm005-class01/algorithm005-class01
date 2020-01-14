# 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
#
# 示例 1:
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
# Related Topics 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def coinChange0(self, coins, amount):
        def dp(n):
            if n == 0:
                return 0
            if n < 0:
                return -1
            res = float('inf')
            for c in coins:
                sub = dp(n - c)
                if sub == -1:
                    continue
                res = min(sub + 1, res)
            return res if res != float('inf') else -1
        return dp(amount)

    def coinChange1(self, coins, amount):
        def dp(n, mem):
            if n in mem:
                return mem[n]

            if n == 0:
                return 0
            if n < 0:
                return -1

            res = float('inf')
            for c in coins:
                sub = dp(n - c, mem)
                if sub == -1:
                    continue
                res = min(sub + 1, res)
            mem[n] = res if res != float('inf') else -1
            return mem[n]

        return dp(amount, {})

    def coinChange2(self, coins, amount):
        """
        dp = min(dp[n-coin] + 1, dp[i])
        dp[0] = 0
        n - coin < 0, -1
        """
        n = amount + 1  # 数组下标从0 开始
        dp = [float('inf')] * n
        dp[0] = 0
        for i in range(0, n):
            for c in coins:
                if i - c < 0:
                    continue
                dp[i] = min(dp[i], dp[i - c] + 1)
        return dp[amount] if dp[amount] != float('inf') else -1

    def coinChange(self, coins, amount):
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0

        for coin in coins:
            for x in range(coin, amount + 1):
                dp[x] = min(dp[x], dp[x - coin] + 1)
        return dp[amount] if dp[amount] != float('inf') else -1

# leetcode submit region end(Prohibit modification and deletion)

print(Solution().coinChange([1, 2, 5], 11))
