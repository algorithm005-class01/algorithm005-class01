# 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
#
# 示例 1:
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
# Related Topics 字符串 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def longestValidParentheses(self, s):
        """
        时间复杂度：O(2n)
        空间复杂度： O（n）
        :param s:
        :return:
        """

        stack = []
        dp = [0] * len(s)
        for indx, i in enumerate(list(s)):
            # print(stack)
            if i == ')':
                y, top = stack.pop() if stack else (0, '')
                if top != '(':
                    dp[indx] = 0
                else:
                    # dp[y] = dp[indx] = indx - y + 1
                    dp[y] = dp[indx] = 1
            else:
                stack.append((indx, i))
        print(dp)
        m = 0
        c = 0
        for x in dp:
            if x == 1:
                c += 1
            else:
                m = max(c, m)
                c = 0
        m = max(c, m)
        return m

    def longestValidParentheses(self, s):
        """
            stack 维护的是长度 这个方法比较巧妙， 很难想到
        """
        stack = [-1]
        maxs = 0
        for i, p in enumerate(s):
            if p == ')':
                stack.pop()
                if stack:
                    maxs = max(maxs, i - stack[-1])
                else:
                    stack.append(i)
            else:
                stack.append(i)
        print(maxs)
        return maxs


# leetcode submit region end(Prohibit modification and deletion)
Solution().longestValidParentheses(")()())")
Solution().longestValidParentheses(")()()())()")
Solution().longestValidParentheses("(((())))")
