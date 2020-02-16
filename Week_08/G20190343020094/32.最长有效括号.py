#
# @lc app=leetcode.cn id=32 lang=python3
#
# [32] 最长有效括号
#

# @lc code=start
class Solution:
    # 反正状态我是定义不出来，头晕
    # https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode/
    def longestValidParentheses_dp(self, s: str) -> int:
        if not s: return 0
        n=len(s)
        dp=[0]*n
        for i in range(1,len(s)):
            if s[i] == ")":
                if s[i-1] == "(":
                    dp[i] = dp[i-2] + 2
                if s[i-1] == ")" and i - dp[i-1] - 1 >= 0 and s[i-dp[i-1]-1] == "(":
                    dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
                # print(i, dp[i-1], i - dp[i-1] - 1)
        # print(dp)
        return max(dp)

    # stack 用栈
    # 对于遇到的每个 ‘(’ ，我们将它的下标放入栈中。
    # 对于遇到的每个 ‘)’ ，我们弹出栈顶的元素并将当前元素的下标与弹出元素下标作差，
    # 得出当前有效括号字符串的长度。通过这种方法，我们继续计算有效子字符串的长度，并最终返回最长有效子字符串的长度。
    def longestValidParentheses(self, s: str) -> int:
        res = 0
        stack = [-1]
        for i in range(len(s)):
            if s[i] == '(':
                stack.append(i)
            else:
                stack.pop()
                if not stack:
                    stack.append(i)
                else:
                    res = max(res, i-stack[-1])
            # print(stack, res)
        return res

# @lc code=end
if __name__ == "__main__":
    s = ')((()())))'
    res = Solution().longestValidParentheses(s)
    print(res)