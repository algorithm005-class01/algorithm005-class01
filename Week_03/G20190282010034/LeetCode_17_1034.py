# -*- coding: utf-8 -*-
# @Time    : 2019/12/27 0027 20:52
# @Author  : songzhenxi
# @Email   : songzx_2326@163.com
# @File    : LeetCode_17_1034.py
# @Software: PyCharm

# 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
#
# 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
#
#
#
# 示例:
#
# 输入："23"
# 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
#
#
# 说明:
# 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
# Related Topics 字符串 回溯算法


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def __init__(self):
        self.MEMO = ['', '', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz']

    def letterCombinations(self, digits):
        """
        题目：17.电话号码的字母组合（https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/）
        学号：1034（五期一班三组）
        :type digits: str
        :rtype: List[str]
        """
        return self.helper([], '', digits, 0) if digits else []

    def helper(self, res, s, digits, level):
        if level == len(digits):
            res.append(s)
            return res
        coolie = self.MEMO[ord(digits[level]) - ord('0')]
        for cl in coolie:
            self.helper(res, '{0}{1}'.format(s, cl), digits, level + 1)
        return res
# leetcode submit region end(Prohibit modification and deletion)
