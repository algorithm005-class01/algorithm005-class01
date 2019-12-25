#!/user/bin/python
#-*- coding:utf-8 -*-

from typing import List

class Solution:
    #T(n) = O(2^n)
    def combine(self, n: int, k: int) -> List[List[int]]:
        self.r = []
        self.n = n
        self.count = 0
        self.backTracking(1, k, [])
        print(self.count)
        return self.r
    
    def backTracking(self, element: int, length: int, array: List[int]):
        self.count+= 1
        if not length: 
            self.r.append(array)
            return
        if element > self.n: return
        self.backTracking(element + 1, length, array)
        self.backTracking(element + 1, length - 1, array + [element])


        


import unittest
class SolutionTest(unittest.TestCase):
    def isEqual(self, a:List[List[int]], b:List[List[int]])->bool:
        if len(a) != len(b):
            return False
        for l in a:
            if l not in b:
                return False
        return True

    def testSolution(self):
        solution = Solution()
        output = [[2,4], [3,4], [2,3],[1,2],[1,3],[1,4]]
        self.assertTrue(self.isEqual(solution.combine(4, 2), output))

if __name__ == "__main__" : unittest.main()