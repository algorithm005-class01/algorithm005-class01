# -*- coding: utf-8 -*-
# @Time    : 2019-12-20 16:17
# @Author  : songzhenxi
# @Email   : songzx_2326@163.com
# @File    : LeetCode_242_1034.py
# @Software: PyCharm

# 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
#
# 示例 1:
#
# 输入: s = "anagram", t = "nagaram"
# 输出: true
#
#
# 示例 2:
#
# 输入: s = "rat", t = "car"
# 输出: false
#
# 说明:
# 你可以假设字符串只包含小写字母。
#
# 进阶:
# 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
# Related Topics 排序 哈希表


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def isAnagram(self, s, t):
        """
        题目：242.有效字母异位词（https://leetcode-cn.com/problems/valid-anagram/）
        学号：1034（五期一班三组）
        标签：排序 哈希表
        :type s: str
        :type t: str
        :rtype: bool
        """
        arr = [0] * 26
        for ism in s:
            arr[ord(ism) - ord('a')] += 1
        for ist in t:
            arr[ord(ist) - ord('a')] -= 1
        arr.sort()
        return arr[-1] == 0 and arr[0] == 0

# leetcode submit region end(Prohibit modification and deletion)
