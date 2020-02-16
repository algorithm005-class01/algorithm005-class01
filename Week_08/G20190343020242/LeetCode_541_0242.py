#
# @lc app=leetcode.cn id=541 lang=python3
#
# [541] 反转字符串 II
#
# https://leetcode-cn.com/problems/reverse-string-ii/description/
#
# algorithms
# Easy (50.28%)
# Likes:    58
# Dislikes: 0
# Total Accepted:    10.3K
# Total Submissions: 20.1K
# Testcase Example:  '"abcdefg"\n2'
#
# 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k
# 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
#
# 示例:
#
#
# 输入: s = "abcdefg", k = 2
# 输出: "bacdfeg"
#
#
# 要求:
#
#
# 该字符串只包含小写的英文字母。
# 给定字符串的长度和 k 在[1, 10000]范围内。
#
#
#


# @lc code=start
class Solution:

    def reverseStr(self, s: str, k: int) -> str:
        # n = len(s)
        # ans = ''
        # for i in range(0, n, 2 * k):
        #     if i + 2 * k <= n:
        #         sub = s[i:i + k][::-1] + s[i + k:i + 2 * k]
        #     elif i + 2 * k - n < k:
        #         sub = s[i:i + k][::-1] + s[i + k:]
        #     else:
        #         sub = s[i:][::-1]
        #     ans += sub
        # return ans
        a = list(s)
        for i in range(0, len(a), 2 * k):
            a[i:i + k] = reversed(a[i:i + k])
        return ''.join(a)


# @lc code=end
