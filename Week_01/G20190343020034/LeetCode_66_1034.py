# -*- coding: utf-8 -*-
# @Time    : 2019-12-13 10:59
# @Author  : songzhenxi
# @Email   : songzx_2326@163.com
# @File    : LeetCode_66_1034.py
# @Software: PyCharm

# 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
#
# 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
#
# 你可以假设除了整数 0 之外，这个整数不会以零开头。
#
# 示例 1:
#
# 输入: [1,2,3]
# 输出: [1,2,4]
# 解释: 输入数组表示数字 123。
#
#
# 示例 2:
#
# 输入: [4,3,2,1]
# 输出: [4,3,2,2]
# 解释: 输入数组表示数字 4321。
#
# Related Topics 数组


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def plusOne(self, digits):
        """
        题目：66.加一（https://leetcode-cn.com/problems/plus-one/）
        标签：数组
        学号：1034（五期一班三组）
       :type digits: List[int]
        :rtype: List[int]
        """
        p = len(digits) - 1
        while p >= 0:
            if digits[p] < 9:
                digits[p] += 1
                return digits
            digits[p], p = 0, p - 1
        digits.append(0)
        digits[0] = 1
        return digits

# leetcode submit region end(Prohibit modification and deletion)
