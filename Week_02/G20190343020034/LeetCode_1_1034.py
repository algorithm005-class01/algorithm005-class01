# -*- coding: utf-8 -*-
# @Time    : 2019-12-20 16:35
# @Author  : songzhenxi
# @Email   : songzx_2326@163.com
# @File    : LeetCode_1_1034.py
# @Software: PyCharm

# 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
#
# 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
#
# 示例:
#
# 给定 nums = [2, 7, 11, 15], target = 9
#
# 因为 nums[0] + nums[1] = 2 + 7 = 9
# 所以返回 [0, 1]
#
# Related Topics 数组 哈希表


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def twoSum(self, nums, target):
        """
        题目：1.两数之和（https://leetcode-cn.com/problems/two-sum/description/）
        学号：1034（五期一班三组）
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        cache = {}
        for (i, num) in enumerate(nums):
            if target - num in cache:
                return [cache[target - num], i]
            cache[num] = i
        return []
# leetcode submit region end(Prohibit modification and deletion)
