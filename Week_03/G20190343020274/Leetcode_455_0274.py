#!/user/bin/python
#-*- coding:utf-8 -*-


from typing import List
from collections import defaultdict
class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        r = 0
        for need in g:
            for i in range(len(s)):
                if s[i] >= need:
                    s[i], r = 0, r + 1
                    break
        return r

    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        g.sort()
        s.sort()
        childs, cookies = 0, 0
        while childs < len(g) and cookies < len(s):
            if s[cookies] >= g[childs]:
                childs += 1
            cookies += 1
        return childs


import unittest
class SolutionTest(unittest.TestCase):
    def testSolution(self):
        solution = Solution()
        self.assertTrue(solution.findContentChildren([1, 2, 3], [1, 1]) == 1)
        self.assertTrue(solution.findContentChildren([1, 2], [1, 2, 3]) == 2)

if __name__ == "__main__" : unittest.main()
