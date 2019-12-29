# -*- coding: utf-8 -*-
# @Time    : 2019-12-20 16:49
# @Author  : songzhenxi
# @Email   : songzx_2326@163.com
# @File    : LeetCode_49_1034.py
# @Software: PyCharm

# 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
#
# 示例:
#
# 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
# 输出:
# [
#  ["ate","eat","tea"],
#  ["nat","tan"],
#  ["bat"]
# ]
#
# 说明：
#
#
# 所有输入均为小写字母。
# 不考虑答案输出的顺序。
#
# Related Topics 哈希表 字符串


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def groupAnagrams(self, strs):
        """
        题目：49.字母异位词分组（https://leetcode-cn.com/problems/group-anagrams/）
        学号：1034（五期一班三组）
        标签：哈希表 字符串
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        cache = {}
        for s in strs:
            ks = ''.join(sorted(s))
            if ks not in cache:
                cache[ks] = []
            cache[ks].append(s)
        return cache.values()
# leetcode submit region end(Prohibit modification and deletion)
