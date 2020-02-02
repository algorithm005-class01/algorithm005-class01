# 53. Maximum Subarray

class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        # 1. 暴力: n^2
        # 2. DP:
        #  a. 分治(子问题)：max_sum(i) = MAX(max_sum(i-1), 0) + a[i]
        #  b. 定义状态数组: f[i]
        #  c. DP 方程: f[i] = MAX(f[i-1], 0) + a[i]
        
        # dp[i] = max(nums[i], nums[i]+dp[i-1])
        # 最大子序和 = 当前元素自身最大，或者 包含之前后最大
        
        dp = nums
        for i in range(1, len(dp)):
            dp[i] = max(nums[i], nums[i] + dp[i-1])
        return max(dp)