# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/valid-parentheses"""


# Python Stack: [] (push: append(); pop: pop(); peek: [len()-1])
class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) & 1 != 0:
            return False
        dictmap = {")": "(", "}": "{", "]": "["}
        stack = []
        for item in s:
            if item in dictmap:
                if not stack:
                    return False
                top = stack.pop()
                if dictmap[item] != top:
                    return False
            else:
                stack.append(item)
        return not stack


if __name__ == '__main__':
    s = '{}({})[{}]'
    print(Solution().isValid(s))
