#
# @lc app=leetcode.cn id=917 lang=python3
#
# [917] 仅仅反转字母
#
# https://leetcode-cn.com/problems/reverse-only-letters/description/
#
# algorithms
# Easy (52.22%)
# Likes:    36
# Dislikes: 0
# Total Accepted:    8.1K
# Total Submissions: 15.2K
# Testcase Example:  '"ab-cd"'
#
# 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
#
#
#
#
#
#
# 示例 1：
#
# 输入："ab-cd"
# 输出："dc-ba"
#
#
# 示例 2：
#
# 输入："a-bC-dEf-ghIj"
# 输出："j-Ih-gfE-dCba"
#
#
# 示例 3：
#
# 输入："Test1ng-Leet=code-Q!"
# 输出："Qedo1ct-eeLg=ntse-T!"
#
#
#
#
# 提示：
#
#
# S.length <= 100
# 33 <= S[i].ASCIIcode <= 122
# S 中不包含 \ or "
#
#
#

from typing import List


# @lc code=start
class Solution:

    def reverseOnlyLetters_1(self, S: str) -> str:
        # 反转指针
        S = list(S)
        i, j = 0, len(S) - 1
        while i < j:
            if not S[i].isalpha():
                i += 1
                continue
            if not S[j].isalpha():
                j -= 1
                continue
            if S[i].isalpha() and S[j].isalpha():
                S[i], S[j] = S[j], S[i]
                i += 1
                j -= 1
        return ''.join(S)


    def reverseOnlyLetters(self, S: str) -> str:
        # 栈
        letters = [c for c in S if c.isalpha()]
        ans = []
        for c in S:
            if c.isalpha():
                ans.append(letters.pop())
            else:
                ans.append(c)
        return ''.join(ans)


    def reverseOnlyLetters_2(self, S: str) -> str:
        # 栈
        letters = [c for c in S if c.isalpha()]
        res = ''
        for c in S:
            if c.isalpha():
                res += letters.pop()
            else:
                res += c
        return res


# @lc code=end
