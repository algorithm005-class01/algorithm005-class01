#
# @lc app=leetcode.cn id=589 lang=python3
#
# [589] N叉树的前序遍历
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
# class Solution:
#     def preorder(self, root: 'Node') -> List[int]:
#         res = []
#         if root == None: return res

#         def recursion(root, res):
#             res.append(root.val)
#             for child in root.children:
#                 recursion(child, res)
#         recursion(root, res)
#         return res

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        res = []
        if root == None: return res

        stack = [root]
        while stack:
            curr = stack.pop()
            res.append(curr.val)
            stack.extend(curr.children[::-1])
        return res


        
# @lc code=end

