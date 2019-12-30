# -*- coding: utf-8 -*-
# @Time    : 2019/12/27 0027 20:47
# @Author  : songzhenxi
# @Email   : songzx_2326@163.com
# @File    : LeetCode_169_1034.py
# @Software: PyCharm
# 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
#
# 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
#
# 示例 1:
#
# 输入: [3,2,3]
# 输出: 3
#
# 示例 2:
#
# 输入: [2,2,1,1,1,2,2]
# 输出: 2
#
# Related Topics 位运算 数组 分治算法


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def majorityElement(self, nums):
        """
        题目：169.多数元素（https://leetcode-cn.com/problems/majority-element/）
        学号：1034（五期一班三组）
        :type nums: List[int]
        :rtype: int
        """
        return sorted(nums)[len(nums) >> 1] if nums else -1
# leetcode submit region end(Prohibit modification and deletion)
