# 22. Generate Parentheses

# Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

# For example, given n = 3, a solution set is:

# [
#   "((()))",
#   "(()())",
#   "(())()",
#   "()(())",
#   "()()()"
# ]

# def generateParenthesis(n):
#     """
#     :type n: int
#     :rtype: List[str]
#     """
#     # 自顶往下 的编程方式
#     _generate(0, n * 2, "")
        
# def _generate(level, MAX, s):
#     # recursion terminator
#     if level >= MAX:
#         print(s)
#         return
#     # process logic in current level
#     _generate(level+1, MAX, s+'(')
#     _generate(level+1, MAX, s+')')

#     # reverse the current level status if needed

# 上面的代码会把所有的情况都打印出来，那我们来想想怎么过滤无效的括号呢？
# left 随时加 只要别超标
# right 必须之前有左括号 左括号>右括号
# 剪枝 提前去掉无用的

def generateParenthesis(n):
    """
    :type n: int
    :rtype: List[str]
    """
    # 自顶往下 的编程方式
    res = []
    _generate(0, 0, n, "", res)
    return res
        
def _generate(left, right, n, s, res):
    # recursion terminator
    if left == n and right == n:
        res.append(s)
        return
    # process logic in current level
    if left < n:
        _generate(left+1, right, n, s+'(', res)
    if left > right:
        _generate(left, right+1, n, s+')', res)

    # reverse the current level status if needed
    

print(generateParenthesis(3))
