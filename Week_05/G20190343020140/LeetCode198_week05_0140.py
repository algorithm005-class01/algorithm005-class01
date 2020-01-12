#解法1，dp 算法，当前所得的最大收益 = 前前个屋子累积的最大收益 + 当前屋子偷到的收益， 比上前一个屋子偷到的收益
class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        left = right = 0
        n = len(nums)
        dp = [0] * (n+1)
        dp[1] = nums[0]
        for i in range(2,n+1):
            dp[i] = max(dp[i-2] + nums[i-1],dp[i-1])
        return dp[-1]

#解法2，用两个参数存结果，优化DP

class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if not nums:
            return 0
        last,now = 0,0
        for i in nums:
            last,now = now, max(last + i,now)
        return now
