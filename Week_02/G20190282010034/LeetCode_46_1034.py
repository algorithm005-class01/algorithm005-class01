# -*- coding: utf-8 -*-
# @Time    : 2019-12-20 17:46
# @Author  : songzhenxi
# @Email   : songzx_2326@163.com
# @File    : LeetCode_46_1034.py
# @Software: PyCharm

# 给定一个没有重复数字的序列，返回其所有可能的全排列。
#
# 示例:
#
# 输入: [1,2,3]
# 输出:
# [
#  [1,2,3],
#  [1,3,2],
#  [2,1,3],
#  [2,3,1],
#  [3,1,2],
#  [3,2,1]
# ]
# Related Topics 回溯算法


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def permute(self, nums):
        """
        题目：46.全排列（https://leetcode-cn.com/problems/permutations/）
        学号：1034（五期一班三组）
        标签：递归 回溯
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        return self.helper([], [], nums)

    def helper(self, reslst, tmplst, nums):
        if len(tmplst) == len(nums):
            reslst.append(list(tmplst))
            return reslst
        for num in nums:
            if num not in tmplst:
                tmplst.append(num)
                self.helper(reslst, tmplst, nums)
                tmplst.pop()
        return reslst
# leetcode submit region end(Prohibit modification and deletion)
