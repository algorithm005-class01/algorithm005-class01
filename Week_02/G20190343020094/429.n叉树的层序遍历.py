#
# @lc app=leetcode.cn id=429 lang=python3
#
# [429] N叉树的层序遍历
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
#     # 每层记录节点的值，放到数组中，并记录下一层的children。重复之前的操作
#     def levelOrder(self, root: 'Node') -> List[List[int]]:
#         if not root:
#             return []
#         res = []
#         cur = [root]
#         while cur:
#             next = []
#             temp = []
#             for node in cur:
#                 temp.append(node.val)
#                 next += node.children
#             res.append(temp)
#             cur = next
#         return res      
# 
# 
# class Solution(object):
#     def levelOrder(self, root):
#         L = []
#         self.traverse(root,0,L)
#         return L
    
#     def traverse(self,root, depth, L):
#         if root == None:
#             return
#         if len(L) == depth:# 如果该层还没有层级数组，则初始化一个
#             L.append([])
#         L[depth].append(root.val)# 将同一层的元素加入level中
#         for x in root.children:# 遍历孩子
#             self.traverse(x, depth+1, L)
# 这个turkey boy的代码tql，充满了伪代码的味道，记录一层一层的值。
class Solution(object):
    def levelOrder(self, root):
        q, ret = [root], []
        while any(q):
            ret.append([node.val for node in q])
            q = [child for node in q for child in node.children if child]
        return ret

# @lc code=end

