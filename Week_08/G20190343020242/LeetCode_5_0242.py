#
# @lc app=leetcode.cn id=5 lang=python3
#
# [5] 最长回文子串
#
# https://leetcode-cn.com/problems/longest-palindromic-substring/description/
#
# algorithms
# Medium (27.73%)
# Likes:    1652
# Dislikes: 0
# Total Accepted:    169.4K
# Total Submissions: 602K
# Testcase Example:  '"babad"'
#
# 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
#
# 示例 1：
#
# 输入: "babad"
# 输出: "bab"
# 注意: "aba" 也是一个有效答案。
#
#
# 示例 2：
#
# 输入: "cbbd"
# 输出: "bb"
#
#
#


# @lc code=start
class Solution:

    def longestPalindrome_1(self, s: str) -> str:
        """
        动态规划：
        1. dp[i][j] 表示 s[j:i+1] 是否为回文子串
        2. 状态转移方程：
            - i==j: dp[i][j]=1
            - i-j==1 且 s[i]==s[j]： dp[i][j]=1
            - i-j>1 且 s[i]==s[j] 且 s[j+1:i] 为回文子串，即 dp[i-1][j+1]==1 时：
                dp[i][j]=1
        """
        n = len(s)
        dp = [[0] * n for _ in range(n)]
        ans = ''
        for i in range(n):
            for j in range(i, -1, -1):
                if s[i] == s[j] and (i - j <= 2 or dp[i - 1][j + 1] == 1):
                    dp[i][j] = 1
                    ans = max(ans, s[j:i + 1], key=len)
        return ans

    def longestPalindrome(self, s: str) -> str:
        """
        中心扩展法：从 s 的每个字符向两边扩展，求出最长子串
        辅助函数：_helper，返回最长子串的索引
        - 奇数长子串：_helper(s,i,i)
        - 偶数长子串：_helper(s,i,i+1)
            - 不存在偶数子串时返回 (i+1, i)
        """
        n = len(s)
        res = ''

        def _helper(s, l, r):
            while l >= 0 and r < n:
                if s[l] == s[r]:
                    l -= 1
                    r += 1
                else:
                    break
            return l + 1, r - 1

        for i in range(n):
            start, end = _helper(s, i, i)
            if i < n - 1:
                start, end = max((start, end),
                                 _helper(s, i, i + 1),
                                 key=lambda s: s[1] - s[0])
            res = max(res, s[start:end + 1], key=len)

        return res


# @lc code=end
