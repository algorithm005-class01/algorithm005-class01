# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/longest-palindromic-substring/"""

# DP
class Solution:
    def longestPalindrome(self, s: str) -> str:
        length = len(s)
        if length <= 1:
            return s
        # dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
        dp = [[False for _ in range(length)] for _ in range(length)]
        max_len, start_index = 0, 0
        for j in range(1, length):
            for i in range(0, j + 1):
                if s[i] == s[j]:
                    if j - i <= 2:
                        dp[i][j] = True
                    else:
                        dp[i][j] = dp[i + 1][j - 1]
                else:
                    dp[i][j] = False

                if dp[i][j]:
                    if (j - i + 1) > max_len:
                        max_len = j - i + 1
                        start_index = i
        return s[start_index: start_index + max_len]


# 中心扩散法
class Solution2:
    def longestPalindrome(self, s: str) -> str:
        length = len(s)
        if length <= 1:
            return s

        max_len = 0
        res = None
        # 遍历每个index，由中心向两边扩散，找到以此index为中心位置的最大回文串
        for i in range(length):
            odd_sub, odd_len = self._judg_palindrome(s, length, i, i) #奇数回文，以同一字母为中心
            even_sub, even_len = self._judg_palindrome(s, length, i, i + 1) #偶数回文，以中心左右字母为中心

            cur_sub = odd_sub if odd_len >= even_len else even_sub
            if len(cur_sub) > max_len:
                max_len = len(cur_sub)
                res = cur_sub

        return res

    def _judg_palindrome(self, s, length, left, right):
        i, j = left, right
        while left >= 0 and right < length and s[left] == s[right]:
            left -= 1
            right += 1
        return s[left + 1: right], right - left - 1
