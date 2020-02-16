#解法1
class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        
        dp = [0] * (len(cost))
        dp[0],dp[1] = cost[0],cost[1]
        for i in range(2,len(cost)):
            dp[i] =  cost[i] + min(dp[i-1],dp[i-2])
        return min(dp[-1],dp[-2])

#解法2
class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        
        for i in range(len(cost)-3,-1,-1):
            cost[i] += min(cost[i+1],cost[i+2])
        return min(cost[0],cost[1])
    
#解法3
class Solution(object):
    def minCostClimbingStairs(self, cost):
        """
        :type cost: List[int]
        :rtype: int
        """
        
        f1,f2 = 0, 0
        for x in reversed(cost):
            f1,f2 = x + min(f1,f2),f1
        return min(f1,f2)
