#
# @lc app=leetcode.cn id=17 lang=python3
#
# [17] 电话号码的字母组合
#
# https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
#
# algorithms
# Medium (51.59%)
# Likes:    520
# Dislikes: 0
# Total Accepted:    64.6K
# Total Submissions: 124.9K
# Testcase Example:  '"23"'
#
# 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
#
# 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
#
#
#
# 示例:
#
# 输入："23"
# 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
#
#
# 说明:
# 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
#
#


# @lc code=start
class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        dig2let = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }

        # # 1. python 内置的 product 方法
        # from itertools import product
        # return list(
        #     map(lambda x: ''.join(x),
        #         product(*(dig2let[d] for d in digits)))) if digits else []

        # # 2. 迭代
        # res = [''] if digits else []
        # for d in digits:
        #     res = [r + l for r in res for l in dig2let[d]]
        # return res

        # 3.递归
        def backtrack(combination, next_digits):
            """
            combination: 已经产生的组合， next-digits：接下来准备输入的数字
            """
            if len(next_digits) == 0:
                res.append(combination)
            else:
                for letter in dig2let[next_digits[0]]:
                    backtrack(combination + letter, next_digits[1:])

        res = []
        if digits:
            backtrack('', digits)
        return res


# @lc code=end
