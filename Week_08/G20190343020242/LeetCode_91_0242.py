#
# @lc app=leetcode.cn id=91 lang=python3
#
# [91] 解码方法
#
# https://leetcode-cn.com/problems/decode-ways/description/
#
# algorithms
# Medium (22.32%)
# Likes:    253
# Dislikes: 0
# Total Accepted:    26.9K
# Total Submissions: 119K
# Testcase Example:  '"12"'
#
# 一条包含字母 A-Z 的消息通过以下方式进行了编码：
#
# 'A' -> 1
# 'B' -> 2
# ...
# 'Z' -> 26
#
#
# 给定一个只包含数字的非空字符串，请计算解码方法的总数。
#
# 示例 1:
#
# 输入: "12"
# 输出: 2
# 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
#
#
# 示例 2:
#
# 输入: "226"
# 输出: 3
# 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
#
#
#


# @lc code=start
class Solution:
    def numDecodings_1(self, s: str) -> int:
        # TODO: 边界如何确定，先验证字符串是否可编码?
        # TODO: 简化代码逻辑？？？？
        if not s:
            return 0
        n = len(s)
        if n == 1:
            if s == '0': return 0
            else:
                return 1

        dp = [0] * n
        dp[0] = 0 if s[0] == '0' else 1
        if s[0] == '0' or (s[1] == '0' and int(s[0]) > 2):
            dp[1] = 0
        elif (s[1] == '0' and int(s[0]) <= 2) or int(s[:2]) > 26:
            dp[1] = 1
        else:
            dp[1] = 2

        for i in range(2, n):
            if s[i] == '0':
                if s[i - 1] == '1' or s[i - 1] == '2':
                    dp[i] = dp[i - 2]
                else:
                    return 0
            else:
                if int(s[i - 1]) == 0 or int(s[i - 1:i + 1]) > 26:
                    dp[i] = dp[i - 1]
                else:
                    dp[i] = dp[i - 1] + dp[i - 2]
        return dp[-1]

    def numDecodings(self, s: str) -> int:
        # KEY
        if not s or s[0]=='0':
            return 0
        
        dp = [1] * (len(s))
        for i in range(1, len(s)):
            key = int(s[i - 1:i + 1])

            if key == 10 or key == 20:
                dp[i] = dp[i - 2] if i>=2 else 1
            elif key in range(30, 100, 10) or key==0:
                return 0
            elif 0 < key < 10 or key > 26:
                dp[i] = dp[i - 1]
            else:
                dp[i] = dp[i - 1] + dp[i - 2] if i>=2 else 2
        return dp[-1]


# @lc code=end
s = '12'
Solution().numDecodings(s)