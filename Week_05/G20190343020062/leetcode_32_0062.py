#给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
#
# 示例 1:
#
# 输入: "(()"
#输出: 2
#解释: 最长有效括号子串为 "()"
#
#
# 示例 2:
#
# 输入: ")()())"
#输出: 4
#解释: 最长有效括号子串为 "()()"
#
# Related Topics 字符串 动态规划



#leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        if(not s):
            return 0
        stack = [-1]
        res = 0
        for i in range(len(s)):
            if(s[i] == "("):
                stack.append(i)
            else:
                stack.pop()
                if(not stack):
                    stack.append(i)
                else:
                    res = max(res , i - stack[-1])
        return res


#leetcode submit region end(Prohibit modification and deletion)
