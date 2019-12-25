#
# @lc app=leetcode.cn id=590 lang=python3
#
# [590] N叉树的后序遍历
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
# class Solution(object):
#     def postorder(self, root):
#         """
#         :type root: Node
#         :rtype: List[int]
#         """
#         if root is None:
#             return []
#         res = []
#         for child in root.children:
#             res.extend(self.postorder(child))
#         res.append(root.val)
#         return res

# class Solution(object):
#     def postorder(self, root):
#             """
#             :type root: Node
#             :rtype: List[int]
#             """
#             res = []
#             if root == None: return res

#             def recursion(root, res):
#                 for child in root.children:
#                     recursion(child, res)
#                 res.append(root.val)

#             recursion(root, res)
#             return res


# 辅助栈，先进后出，根节点先入再子节点，再从栈出来
# 就变成先遍历子节点再到根节点的后续遍历了
# class Solution(object):
#     def postorder(self, root):
#         """
#         :type root: Node
#         :rtype: List[int]
#         """
#         if root is None:
#             return []
        
#         stack, output = [root, ], []
#         while stack:
#             root = stack.pop()
#             if root is not None:
#                 output.append(root.val)
#             for c in root.children:
#                 stack.append(c)
                
#         return output[::-1]

class Solution(object):
    def postorder(self, root):
            res = []
            if root == None: return res

            stack = [root]
            while stack:
                curr = stack.pop()
                res.append(curr.val)
                stack.extend(curr.children)

            return res[::-1]



# @lc code=end

