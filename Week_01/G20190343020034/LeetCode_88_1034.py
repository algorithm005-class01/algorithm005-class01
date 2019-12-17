# -*- coding: utf-8 -*-
# @Time    : 2019-12-13 11:37
# @Author  : songzhenxi
# @Email   : songzx_2326@163.com
# @File    : LeetCode_88_1034.py
# @Software: PyCharm

# 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
#
# 说明:
#
#
# 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
# 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
#
#
# 示例:
#
# 输入:
# nums1 = [1,2,3,0,0,0], m = 3
# nums2 = [2,5,6],       n = 3
#
# 输出: [1,2,2,3,5,6]
# Related Topics 数组 双指针


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        题目：88.合并两个有序数组（https://leetcode-cn.com/problems/merge-sorted-array/）
        标签：双指针 数组
        学号：1034（五期一班三组）
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: None Do not return anything, modify nums1 in-place instead.
        """
        p = m + n - 1
        m, n = m - 1, n - 1
        while m >= 0 and n >= 0:
            if nums1[m] > nums2[n]:
                nums1[p], m, p = nums1[m], m - 1, p - 1
            else:
                nums1[p], n, p = nums2[n], n - 1, p - 1
        while n >= 0:
            nums1[n], n = nums2[n], n - 1

# leetcode submit region end(Prohibit modification and deletion)
