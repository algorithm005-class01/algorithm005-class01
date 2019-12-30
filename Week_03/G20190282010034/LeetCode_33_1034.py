# -*- coding: utf-8 -*-
# @Time    : 2019/12/27 0027 21:03
# @Author  : songzhenxi
# @Email   : songzx_2326@163.com
# @File    : LeetCode_33_1034.py
# @Software: PyCharm

# 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
#
# ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
#
# 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
#
# 你可以假设数组中不存在重复的元素。
#
# 你的算法时间复杂度必须是 O(log n) 级别。
#
# 示例 1:
#
# 输入: nums = [4,5,6,7,0,1,2], target = 0
# 输出: 4
#
#
# 示例 2:
#
# 输入: nums = [4,5,6,7,0,1,2], target = 3
# 输出: -1
# Related Topics 数组 二分查找


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def search(self, nums, target):
        """
        题目：33.搜索旋转排序数组（https://leetcode-cn.com/problems/search-in-rotated-sorted-array/）
        学号：1034（五期一班三组）
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        left, right = 0, len(nums) - 1
        while left < right:
            amid = (left + right) >> 1
            if nums[amid] == target:
                return amid
            elif nums[amid] < nums[left]:
                if nums[amid] < target <= nums[right]:
                    left = amid + 1
                else:
                    right = amid - 1
            else:
                if nums[left] <= target < nums[amid]:
                    right = amid - 1
                else:
                    left = amid + 1
        return left if nums and nums[left] == target else -1


# leetcode submit region end(Prohibit modification and deletion)
