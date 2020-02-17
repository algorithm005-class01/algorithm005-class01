#!/user/bin/python
#-*- coding:utf-8 -*-


#A message containing letters from A-Z is being encoded to numbers using the following mapping:
#'A' -> 1
#'B' -> 2
#...
#'Z' -> 26
#Given a non-empty string containing only digits, determine the total number of ways to decode it.
class Solution:
    #BruteForce O(2^len(s))
    def numDecodings(self, s: str) -> int:
        if not s: return 0
        elif len(s) == 1: return 0 if not int(s) else 1        
        elif len(s) == 2: 
            num = int(s[0:2])
            if num < 10: return 0
            elif (num == 10 or num == 20): return 1
            elif num <= 26: return 2
            else: return self.numDecodings(s[1:])
        else: 
            num, next = int(s[0:2]), int(s[2])
            if num < 10: return 0
            elif (num == 10 or num == 20) and not next: return 0
            elif (num == 10 or num == 20) and next: return self.numDecodings(s[2:])
            elif num <= 26 and not next: return self.numDecodings(s[1:])
            elif num <= 26 and next: return self.numDecodings(s[1:]) + self.numDecodings(s[2:])
            else: return self.numDecodings(s[1:])


    def numDecodings_dp_v1(self, s: str) -> int:
        if not s: return 0
        r = [0] * len(s)
        for i in range(len(s)):
            if not i and not int(s[i]):
                return 0
            elif not i and int(s[i]):
                r[i] = 1
            elif not int(s[i]) and (not int(s[i-1]) or int(s[i-1]) > 2):
                return 0
            elif not int(s[i]) and (0 < int(s[i-1]) < 3) and i == 1:
                r[i] = 1
            elif not int(s[i]) and (0 < int(s[i-1]) < 3) and i > 1:
                r[i] = r[i-2]
            elif int(s[i]) and not int(s[i-1]):
                r[i] = r[i-1]
            elif int(s[i]) and int(s[i-1]) and i == 1:
                r[i] = r[i-1] + (1 if int(s[i-1:i+1]) <=26 else 0)
            else:
                r[i] = r[i-1] + (r[i-2] if int(s[i-1:i+1]) <=26 else 0)
        return r[len(s)-1]

    # if s[i] == '0' and s[i-1] == '1' or '2': dp[i] = dp[i-2]
    # if s[i-1]= '1' dp[i] = dp[i-1] + dp[i-2]
    # if s[i-1] = '2' and  '1' <= s[i] <='6', dp[i] = dp[i-1]
    def numDecodings_dp_v1(self, s: str) -> int:


#Given a binary tree, return the inorder traversal of its nodes' values.
import unittest
class SolutionTest(unittest.TestCase):
    def testSolution(self):
        solution = Solution()
        self.assertTrue(solution.numDecodings('101') == 1)
        self.assertTrue(solution.numDecodings('12120') == 3)
        self.assertTrue(solution.numDecodings('27') == 1)
        self.assertTrue(solution.numDecodings('110') == 1)
        self.assertTrue(solution.numDecodings('12') == 2)
        self.assertTrue(solution.numDecodings("226") == 3)
        self.assertTrue(solution.numDecodings("0") == 0)
        self.assertTrue(solution.numDecodings("10") == 1)
        self.assertTrue(solution.numDecodings("100") == 0)
        self.assertTrue(solution.numDecodings("1212") == 5)

if __name__ == "__main__" : unittest.main()
