# 322. Coin Change

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        memo = {0: 0}
        
        def helper(n):   
            if n in memo:
                return memo[n]
            
            res = float("inf")
            for coin in coins:
                if n >= coin:
                    res = min(res, helper(n-coin) + 1)
            memo[n] = res
            return res
        
        return helper(amount) if (helper(amount) != float("inf")) else -1