# 322. Coin Change

# You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

# Example 1:

# Input: coins = [1, 2, 5], amount = 11
# Output: 3 
# Explanation: 11 = 5 + 5 + 1
# Example 2:

# Input: coins = [2], amount = 3
# Output: -1

class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        
        dp = [float("inf")] * (amount+1)
        dp[0] = 0
        
        for i in range(1, amount+1):
            for coin in coins:
                if i >= coin:
                    dp[i] = min(dp[i], dp[i-coin]+1)
        return dp[-1] if dp[-1] != float("inf") else -1
        
#         memo = {0: 0}
        
#         def helper(n):   
#             if n in memo:
#                 return memo[n]
            
#             res = float("inf")
#             for coin in coins:
#                 if n >= coin:
#                     res = min(res,helper(n-coin)+1)
#             memo[n] = res
#             return res
        
#         return helper(amount) if (helper(amount) != float("inf")) else -1