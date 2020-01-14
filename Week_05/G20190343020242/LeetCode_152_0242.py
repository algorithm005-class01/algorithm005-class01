#
# @lc app=leetcode.cn id=152 lang=python3
#
# [152] 乘积最大子序列
#
# https://leetcode-cn.com/problems/maximum-product-subarray/description/
#
# algorithms
# Medium (36.15%)
# Likes:    346
# Dislikes: 0
# Total Accepted:    29.7K
# Total Submissions: 81.5K
# Testcase Example:  '[2,3,-2,4]'
#
# 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
#
# 示例 1:
#
# 输入: [2,3,-2,4]
# 输出: 6
# 解释: 子数组 [2,3] 有最大乘积 6。
#
#
# 示例 2:
#
# 输入: [-2,0,-1]
# 输出: 0
# 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
#
#
from typing import List


# @lc code=start
class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        # 遍历时，max_prod/min_prod 分别表示以 nums[i] 元素结尾的连续子序列的最大乘积和最小乘积
        # 从 i-1 遍历至 i 时，要么将 i-1 的连续子序列延长至元素 i，要么将其重置为只有元素 i
        res = nums[0]
        max_prod = min_prod = 1
        for num in nums:
            if num < 0:
                max_prod, min_prod = min_prod, max_prod
            max_prod = max(max_prod * num, num)
            min_prod = min(min_prod * num, num)
            res = max(res, max_prod)
        return res


# @lc code=end
nums = [2, 3, -2, 4, -1]
Solution().maxProduct(nums)