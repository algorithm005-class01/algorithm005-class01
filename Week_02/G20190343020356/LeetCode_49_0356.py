# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/group-anagrams"""
from typing import List


class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dictmap = {}
        for s in strs:
            key = ''.join(sorted(s))
            if key not in dictmap:
                dictmap[key] = []
            dictmap[key].append(s)
        return list(dictmap.values())


if __name__ == '__main__':
    strs = []
    print(Solution().groupAnagrams(strs))
