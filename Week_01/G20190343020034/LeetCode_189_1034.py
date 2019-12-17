# -*- coding: utf-8 -*-
# @Time    : 2019-12-10 13:07
# @Author  : songzhenxi
# @Email   : songzx_2326@163.com
# @File    : LeetCode_189_1034.py
# @Software: PyCharm


# 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
#
# 示例 1:
#
# 输入: [1,2,3,4,5,6,7] 和 k = 3
# 输出: [5,6,7,1,2,3,4]
# 解释:
# 向右旋转 1 步: [7,1,2,3,4,5,6]
# 向右旋转 2 步: [6,7,1,2,3,4,5]
# 向右旋转 3 步: [5,6,7,1,2,3,4]
#
#
# 示例 2:
#
# 输入: [-1,-100,3,99] 和 k = 2
# 输出: [3,99,-1,-100]
# 解释:
# 向右旋转 1 步: [99,-1,-100,3]
# 向右旋转 2 步: [3,99,-1,-100]
#
# 说明:
#
#
# 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
# 要求使用空间复杂度为 O(1) 的 原地 算法。
#
# Related Topics 数组

# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def rotate(self, nums, k):
        """
        题目：189.旋转数组（https://leetcode-cn.com/problems/rotate-array/submissions/）
        标签：数组 双指针
        学号：1034（五期一班三组）
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        def reverse(begin, end, arry):
            while begin < end:
                arry[begin], arry[end] = arry[end], arry[begin]
                begin, end = begin + 1, end - 1
        k, p = k % len(nums), len(nums)
        if k > 0:
            reverse(0, p - 1, nums)
            reverse(0, k - 1, nums)
            reverse(k, p - 1, nums)
# leetcode submit region end(Prohibit modification and deletion)
