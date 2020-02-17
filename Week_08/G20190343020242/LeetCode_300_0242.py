#
# @lc app=leetcode.cn id=300 lang=python3
#
# [300] 最长上升子序列
#
# https://leetcode-cn.com/problems/longest-increasing-subsequence/description/
#
# algorithms
# Medium (43.48%)
# Likes:    376
# Dislikes: 0
# Total Accepted:    40.8K
# Total Submissions: 93.7K
# Testcase Example:  '[10,9,2,5,3,7,101,18]'
#
# 给定一个无序的整数数组，找到其中最长上升子序列的长度。
#
# 示例:
#
# 输入: [10,9,2,5,3,7,101,18]
# 输出: 4
# 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
#
# 说明:
#
#
# 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
# 你算法的时间复杂度应该为 O(n^2) 。
#
#
# 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
#
#
from typing import List


# @lc code=start
class Solution:

    def lengthOfLIS_1(self, nums: List[int]) -> int:
        # 1. 动态规划：O(N^2)
        # dp[i] 表示以 nums[i] 元素结尾的最长上升子序列
        # nums[i] 比 nums[:i] 都小则为 1
        #

        if not nums:
            return 0

        n = len(nums)
        dp = [1] * n
        for i in range(1, n):
            for j in range(i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)

        return max(dp)

    def lengthOfLIS(self, nums: List[int]) -> int:
        # 1. 二分？？
        # TODO：
        tails = [0] * len(nums)
        res = 0

        for num in nums:
            i, j = 0, res
            while i < j:
                m = (i + j) // 2
                if tails[m] < num:
                    i = m + 1     
                else:
                    j = m
            tails[i] = num
            if j == res:
                res += 1
        return res


# @lc code=end

nums = [4, 10, 4, 3, 8, 9]
Solution().lengthOfLIS(nums)