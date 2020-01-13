#!/user/bin/bash
# -*- coding:utf-8 -*-

#Share
#A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
#The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
#How many possible unique paths are there?

class Solution:
    #brute-force T(n) = O(2^(m+n))
    def uniquePaths_backtracking(self, m: int, n: int) -> int:
        if not m or not n: return 0
        if m == 1 and n == 1: return 1
        return self.uniquePaths(m - 1, n) + self.uniquePaths(m, n - 1)

    #dp T(n) = O(m*n) S(n) = O(m*n)
    def uniquePaths(self, m: int, n: int) -> int:
        if not m or not n : return 0
        r = [[0 for _ in range(n + 1)] for _ in range(m + 1)]
        for j in range(1, n+1):
            for i in range(1, m+1):
                r[i][j] = 1 if i == 1 and j == 1 else (r[i-1][j] + r[i][j-1])
        return r[m][n]

import unittest
class SolutionTest(unittest.TestCase):
    def testSolution(self):
        solution = Solution()
        self.assertTrue(solution.uniquePaths(3, 2) == 3)
        self.assertTrue(solution.uniquePaths(7, 3) == 28)

if __name__ == "__main__" : unittest.main()
