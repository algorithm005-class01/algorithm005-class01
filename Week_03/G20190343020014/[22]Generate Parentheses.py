#给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
#
# 例如，给出 n = 3，生成结果为： 
#
# [
#  "((()))",
#  "(()())",
#  "(())()",
#  "()(())",
#  "()()()"
#]
# 
# Related Topics 字符串 回溯算法



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        result = []

        def backtrack(s, left, right):
            # 满足条件添加结果
            if len(s) == 2 * n:
                result.append(s)

            if left < n:
                backtrack(s + '(', left + 1, right)
            if right < left:
                backtrack(s + ')', left, right + 1)

        backtrack('', 0, 0)
        return result

        
#leetcode submit region end(Prohibit modification and deletion)
x = Solution().generateParenthesis(3)
print(x)
