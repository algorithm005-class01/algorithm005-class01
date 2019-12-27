# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/valid-anagram/"""


class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        dictmap = {}
        if len(s) != len(t):
            return False
        for i in s:
            if i not in dictmap:
                dictmap[i] = 1
            else:
                dictmap[i] += 1
        for i in t:
            try:
                dictmap[i] -= 1
            except KeyError:
                return False
            if dictmap[i] < 0:
                return False
        return True

    def isAnagram_two(self, s, t):
        return sorted(s) == sorted(t)


if __name__ == '__main__':
    s = 'abcdf'
    t = 'cbaed'
    slt = Solution()
    print(slt.isAnagram(s, t))
    print(slt.isAnagram_two(s, t))
