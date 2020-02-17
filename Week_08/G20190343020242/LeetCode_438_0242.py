#
# @lc app=leetcode.cn id=438 lang=python3
#
# [438] 找到字符串中所有字母异位词
#
# https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/description/
#
# algorithms
# Medium (39.33%)
# Likes:    199
# Dislikes: 0
# Total Accepted:    15.6K
# Total Submissions: 38.7K
# Testcase Example:  '"cbaebabacd"\n"abc"'
#
# 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
#
# 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
#
# 说明：
#
#
# 字母异位词指字母相同，但排列不同的字符串。
# 不考虑答案输出的顺序。
#
#
# 示例 1:
#
#
# 输入:
# s: "cbaebabacd" p: "abc"
#
# 输出:
# [0, 6]
#
# 解释:
# 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
# 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
#
#
# 示例 2:
#
#
# 输入:
# s: "abab" p: "ab"
#
# 输出:
# [0, 1, 2]
#
# 解释:
# 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
# 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
# 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
#
#
#
from typing import List


# @lc code=start
class Solution:

    def findAnagrams_1(self, s: str, p: str) -> List[int]:
        # 暴力法

        res = []
        for i in range(len(s) - len(p) + 1):
            a = s[i:i + len(p)]
            if sorted(a) == sorted(p):
                res.append(i)
        return res

    def findAnagrams(self, s: str, p: str) -> List[int]:
        # TODO: 滑动窗口
        res = []
        
        from collections import Counter
        target = Counter(p)

        # target = {}
        # for c in target:
        #     target.get(c, 0) + 1

        window = {}

        l = r = 0     # 窗口左右界限
        while r < len(s):
            char = s[r]
            if char not in target:
                window.clear()
                l = r = r + 1
            else:
                window[char] = window.get(char, 0) + 1
                if r - l + 1 == len(p):
                    if window == target:
                        res.append(l)
                    window[s[l]] -= 1
                    l += 1
                r += 1
        return res


# @lc code=end

s = "abab"
p = "ab"
Solution().findAnagrams(s, p)