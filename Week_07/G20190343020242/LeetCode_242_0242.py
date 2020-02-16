#
# @lc app=leetcode.cn id=242 lang=python3
#
# [242] 有效的字母异位词
#
# https://leetcode-cn.com/problems/valid-anagram/description/
#
# algorithms
# Easy (57.17%)
# Likes:    134
# Dislikes: 0
# Total Accepted:    61.5K
# Total Submissions: 107.4K
# Testcase Example:  '"anagram"\n"nagaram"'
#
# 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
#
# 示例 1:
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
#
#


# @lc code=start
class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # 1. loop ---> dict
        # s_map = {}
        # t_map = {}
        # for char in s:
        #     s_map[char] = s_map.get(char, 0) + 1
        # for char in t:
        #     t_map[char] = t_map.get(char, 0) + 1
        # return t_map == s_map

        # 2. collections.Counter
        # from collections import Counter
        # return Counter(s) == Counter(t)

        # 3. 排序
        return sorted(s) == sorted(t)


# @lc code=end
