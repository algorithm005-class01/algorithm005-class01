#
# @lc app=leetcode.cn id=53 lang=python3
#
# [53] 最大子序和
#
# https://leetcode-cn.com/problems/maximum-subarray/description/
#
# algorithms
# Easy (48.26%)
# Likes:    1468
# Dislikes: 0
# Total Accepted:    140.3K
# Total Submissions: 288.8K
# Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
#
# 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
#
# 示例:
#
# 输入: [-2,1,-3,4,-1,2,1,-5,4],
# 输出: 6
# 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
#
#
# 进阶:
#
# 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
#
#
from typing import List


# @lc code=start
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        # 1. 动态规划，不改变输入数组
        # 连续子序 都是以特定位置 i 的元素为结尾：
        # 遍历数组，sum_{i} 表示以元素 nums[i] 结尾的最大连续子序的和
        res = nums[0]
        sum = 0
        for num in nums:
            if sum > 0:
                sum += num
            else:
                sum = num
            # sum = max(sum + num, num)
            res = max(res, sum)
        return res

    def maxSubArray_1(self, nums: List[int]) -> int:
        # 1. 动态规划，就地改变输入数组
        n = len(nums)
        max_sum = nums[0]
        for i in range(1, n):
            if nums[i - 1] > 0:
                nums[i] += nums[i - 1]
            max_sum = max(max_sum, nums[i])
        return max_sum

    def maxSubArray_2(self, nums: List[int]) -> int:
        # TODO：分治法
        pass


# @lc code=end
