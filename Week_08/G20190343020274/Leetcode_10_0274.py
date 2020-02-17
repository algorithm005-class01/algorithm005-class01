#!/user/bin/python
#-*- coding:utf-8 -*-

class Solution:
    def isMatch0(self, text, pattern):
        if not pattern:
            return not text

        first_match = bool(text) and pattern[0] in {text[0], '.'}

        if len(pattern) >= 2 and pattern[1] == '*':
            return first_match and self.isMatch(text[1:], pattern) or self.isMatch(text, pattern[2:])
        else:
            return first_match and self.isMatch(text[1:], pattern[1:])

    def isMatch(self, text, pattern):
        memo = {}
        def dp(i, j):
            if (i, j) not in memo:
                if j == len(pattern):
                    ans = i == len(text)
                else:
                    first_match = i < len(text) and pattern[j] in {text[i], '.'}
                    if j + 1 < len(pattern) and pattern[j + 1] == '*':
                        ans = first_match and dp(i + 1, j) or dp(i, j + 2)
                    else:
                        ans = first_match and dp(i + 1, j + 1)
                memo[i, j] = ans
            return memo[i, j]
        return dp(0, 0)

    def isMatch(self, text, pattern):
        memo = {}
        def dp(i, j):
            if (i, j) not in memo:
                if j == len(pattern):
                    ans = i == len(text)
                else:
                    first_match = i < len(text) and pattern[j] in {text[i], '.'}
                    if j + 1 < len(pattern) and pattern[j + 1] == '*':
                        ans = first_match and dp(i + 1, j) or dp(i, j + 2)
                    else:
                        ans = first_match and dp(i + 1, j + 1)
                memo[i, j] = ans
            return memo[i, j]
        return dp(0, 0)

    def isMatch(self, text, pattern):
        dp = [[False] * (len(pattern) + 1) for _ in range(len(text) + 1)]
        dp[-1][-1] = True
        for i in range(len(text), -1, -1):
            for j in range(len(pattern) - 1, -1, -1):
                first_match = i < len(text) and pattern[j] in {text[i], '.'}
                if j + 1 < len(pattern) and pattern[j + 1] == '*':
                    d[i][j] = first_match and d[i + 1][j] or d[i][j + 2]
                else:
                    d[i][j] = first_match and d[i + 1][j + 1]
        return dp[0][0] 

import unittest
class SolutionTestCase(unittest.TestCase):
    def testMatch(self):
        solution = Solution()
        self.assertTrue(not solution.isMatch("ab", ".*c"))
        self.assertTrue(not solution.isMatch("", "a"))
        self.assertTrue(not solution.isMatch("aa", "a"))
        self.assertTrue(solution.isMatch("aa", "a*"))
        self.assertTrue(solution.isMatch("ab", ".*"))
        self.assertTrue(solution.isMatch("ab", ".*"))
        self.assertTrue(solution.isMatch("aab", "c*a*b"))
        self.assertTrue(not solution.isMatch("mississippi", "mis*is*p*."))
        self.assertTrue(solution.isMatch("aaa", "a*a"))
        self.assertTrue(solution.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*a*a*b"))
        self.assertTrue(solution.isMatch("aaa", "ab*a*c*a"))
        self.assertTrue(solution.isMatch("aaab", "ab*a*c*ab"))
        self.assertTrue(solution.isMatch("aaab", ".*.."))

if __name__ == "__main__": unittest.main()