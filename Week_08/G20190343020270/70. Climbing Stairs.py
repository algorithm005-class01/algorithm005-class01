# 70. Climbing Stairs

# You are climbing a stair case. It takes n steps to reach to the top.

# Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

# Note: Given n will be a positive integer.

# Example 1:

# Input: 2
# Output: 2
# Explanation: There are two ways to climb to the top.
# 1. 1 step + 1 step
# 2. 2 steps

class Solution(object):
    # dic = {}
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        # 1. using dic
        
        # result = 0
        # if n < 2:
        #     return 1
        # if self.dic.get(n):
        #     result = self.dic[n]
        # else:
        #     result = self.climbStairs(n - 1) + self.climbStairs(n - 2)
        # self.dic[n] = result
        # return result
        
        # 2. f1 f2 f3
        
        # if n <= 2:
        #     return n
        # f1, f2, f3 = 1, 2, 3
        # for i in range(3, n+1):
        #     f3 = f1 + f2
        #     f1 = f2
        #     f2 = f3
        # return f3
        
        # 3. dynamic 1
        # O(n)
        
        # dp = [1] * (n + 1)
        # for i in range(2, n + 1):
        #     dp[i] = dp[i - 1] + dp[i - 2]
        # return dp[n]
        
        # dynamic 2
        # O(n) O(1)
        
        x, y = 1, 1
        for i in range(1, n):
            y, x = x + y, y
        return y
        
# n = 1 1 1
# n = 2 2 1,2
# n = 3 3 111,12,21
# n = 4 5 1111,112,121,211,22

# n = 3 f(1) + f(2)
# n = 4 f(2) + f(3)
# n = 5 ...
# f(n) = f(n-1) + f(n-2)

# 懵逼的时候

# 暴力？基本情况？

# 找最近 重复子问题

# if...else
# for while recursion