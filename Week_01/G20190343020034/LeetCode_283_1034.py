# -*- coding: utf-8 -*-
# @Time    : 2019-12-13 11:15
# @Author  : songzhenxi
# @Email   : songzx_2326@163.com
# @File    : LeetCode_283_1034.py
# @Software: PyCharm

# 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
#
# 示例:
#
# 输入: [0,1,0,3,12]
# 输出: [1,3,12,0,0]
#
# 说明:
#
#
# 必须在原数组上操作，不能拷贝额外的数组。
# 尽量减少操作次数。
#
# Related Topics 数组 双指针


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def moveZeroes(self, nums):
        """
        题目：283.移动零（https://leetcode-cn.com/problems/move-zeroes/）
        标签：数组 双指针
        学号：1034（五期一班三组）
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        zero = 0
        for i in xrange(len(nums)):
            if nums[i] == 0:
                zero += 1
            elif zero > 0:
                nums[i], nums[i - zero] = nums[i - zero], nums[i]
# leetcode submit region end(Prohibit modification and deletion)
