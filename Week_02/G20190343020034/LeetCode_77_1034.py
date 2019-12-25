# -*- coding: utf-8 -*-
# @Time    : 2019-12-20 17:31
# @Author  : songzhenxi
# @Email   : songzx_2326@163.com
# @File    : LeetCode_77_1034.py
# @Software: PyCharm

# 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
#
# 示例:
#
# 输入: n = 4, k = 2
# 输出:
# [
#  [2,4],
#  [3,4],
#  [2,3],
#  [1,2],
#  [1,3],
#  [1,4],
# ]
# Related Topics 回溯算法


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def combine(self, n, k):
        """
        题目：77.组合（https://leetcode-cn.com/problems/combinations/）
        学号：1034（五期一班三组）
        标签：递归 回溯
        :type n: int
        :type k: int
        :rtype: List[List[int]]
        """
        return self.helper([], [], 1, n, k)

    def helper(self, combs, comb, a, n, k):
        if k == 0:
            combs.append(list(comb))
            return combs
        for i in xrange(a, n + 1):
            comb.append(i)
            self.helper(combs, comb, i + 1, n, k - 1)
            comb.pop()
        return combs
# leetcode submit region end(Prohibit modification and deletion)
