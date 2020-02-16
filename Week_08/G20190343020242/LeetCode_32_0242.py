#
# @lc app=leetcode.cn id=32 lang=python3
#
# [32] 最长有效括号
#
# https://leetcode-cn.com/problems/longest-valid-parentheses/description/
#
# algorithms
# Hard (28.86%)
# Likes:    455
# Dislikes: 0
# Total Accepted:    33.4K
# Total Submissions: 114.8K
# Testcase Example:  '"(()"'
#
# 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
#
# 示例 1:
#
# 输入: "(()"
# 输出: 2
# 解释: 最长有效括号子串为 "()"
#
#
# 示例 2:
#
# 输入: ")()())"
# 输出: 4
# 解释: 最长有效括号子串为 "()()"
#
#
#


# @lc code=start
class Solution:

    def longestValidParentheses_1(self, s: str) -> int:
        # 1.暴力法，对所有偶数子串，判断是否合法
        # 超时
        def isValid(string):
            stack = []
            for s in string:
                if s == '(':
                    stack.append(s)
                else:
                    if not stack:
                        return False
                    else:
                        stack.pop()
            return not stack

        n = len(s)
        length = n if n % 2 == 0 else n - 1
        while length > 0:
            for i in range(n - length + 1):
                string = s[i:i + length]
                if isValid(string):
                    return length
            length -= 2
        return 0

    def longestValidParentheses(self, s: str) -> int:
        # 1. 动态规划
        # 数组 dp，dp[i] 表示以 s[i] 结尾的最长有效括号：
        # 形如...() ：dp[i] = dp[i-2]+2
        # 形如...)) ：找到 dp[i-1] 的长度，s[i] 和 第 i-dp[i-1]-1 个元素匹配时
        if not s:
            return 0
        n = len(s)
        dp = [0] * n
        res = 0
        for i in range(1, n):
            if s[i] == ')':
                if s[i - 1] == '(':
                    dp[i] = dp[i - 2] + 2 if i > 2 else 2
                elif i - dp[i - 1] - 1 >= 0 and s[i - dp[i - 1] - 1] == '(':
                    dp[i] = dp[i - 1] + 2 + (
                        dp[i - dp[i - 1] - 2] if i - dp[i - 1] - 2 >= 0 else 0)
                res = max(dp[i], res)
        return res


# @lc code=end

s = "(()())"
Solution().longestValidParentheses(s)