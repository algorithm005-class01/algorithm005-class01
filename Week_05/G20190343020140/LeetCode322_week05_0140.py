#解法1：记忆化递归，用hashtable 存储结果
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        memo = {0:0}
        def helper(n):
            if n in memo:
                return memo[n]
            res = float('inf')
            for coin in coins:
                if n >= coin:
                    res = min(res,helper(n-coin) + 1)
            memo[n] = res
            return res
        return helper(amount) if (helper(amount) != float('inf')) else -1

#解法2，一维dp 算法
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        dp = [float('inf')] * (amount+1)
        dp[0] = 0
        for i in range(1,amount+1):
            for coin in coins:
                if i >= coin:
                    dp[i] = min(dp[i],dp[i-coin] + 1)

        return dp[-1] if (dp[-1] != float('inf')) else -1



#解法3，DFS
class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        coins.sort(reverse=True)
        self.res = float('inf')
        
        def dfs(i,num,amount):
            if amount == 0:
                self.res = min(self.res,num)
                return 
            for j in range(i,len(coins)):
                if (self.res - num) * coins[j] < amount:
                    break
                if coins[j] > amount:
                    continue
                dfs(j,num + 1,amount - coins[j])
        for i in range(len(coins)):
            dfs(i,0,amount)
        return self.res if self.res != float('inf') else -1

#解法4，BFS
    class Solution(object):
    def coinChange(self, coins, amount):
        """
        :type coins: List[int]
        :type amount: int
        :rtype: int
        """
        if amount == 0:
            return 0
        visited = [False] *(amount + 1)
        visited[0] = True
        value1,value2, nc = [0],[],0
        while value1:
            nc += 1
            for v in value1:
                for coin in coins:
                    newval = v + coin
                    if newval <= amount:
                        if not visited[newval]:
                            if newval == amount:
                                return nc
                            visited[newval] = True
                            value2.append(newval)
            value1,value2 = value2,[]
        return -1
