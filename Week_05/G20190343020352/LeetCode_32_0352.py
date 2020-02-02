class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if not str:
            return 0
        length = len(s)
        data = [-1]
        maxLength = 0
        for i in range(length):
            if s[i] == "(":
                data.append(i)
            else:
                data.pop()
                if not data:
                    data.append(i)
                else:
                    maxLength = max(maxLength, i - data[-1])
        return maxLength