#!/user/bin/python
#-*- coding:utf-8 -*-

class Solution(object):
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return n != 0 and not (n & (n - 1))



#Given an integer, write a function to determine if it is a power of two.
import unittest
class SolutionTest(unittest.TestCase):
    def testSolution(self):
        solution = Solution()
        self.assertTrue(not solution.isPowerOfTwo(0))
        self.assertTrue(solution.isPowerOfTwo(1))
        self.assertTrue(solution.isPowerOfTwo(16))
        self.assertTrue(not solution.isPowerOfTwo(218))



if __name__ == "__main__" : unittest.main()
