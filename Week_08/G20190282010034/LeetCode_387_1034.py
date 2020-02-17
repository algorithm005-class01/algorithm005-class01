# -*- coding: utf-8 -*-
# @Time    : 2020/2/16 0016 9:48
# @Author  : songzhenxi
# @Email   : songzx_2326@163.com
# @File    : LeetCode_387_1034.py
# @Software: PyCharm

# 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
#
# 案例:
#
#
# s = "leetcode"
# 返回 0.
#
# s = "loveleetcode",
# 返回 2.
#
#
#
#
# 注意事项：您可以假定该字符串只包含小写字母。
# Related Topics 哈希表 字符串
# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def firstUniqChar(self, s):
        """
        题目：387.字符串中的第一个唯一字符
        （https://leetcode-cn.com/problems/first-unique-character-in-a-string/）
        学号：1034（五期一班三组）
        :type s: str
        :rtype: int
        """
        memo = [0] * 256
        for t in s:
            memo[ord(t)] += 1
        for i, t in enumerate(s):
            if memo[ord(t)] == 1:
                return i
        return -1
# leetcode submit region end(Prohibit modification and deletion)
