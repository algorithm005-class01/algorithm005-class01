# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/assign-cookies/"""
from typing import List


class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        count = 0
        g_index = 0
        for i in range(len(s)):
            if s[i] >= g[g_index]:
                count += 1
                g_index += 1
            if g_index >= len(g):
                break
        return count
