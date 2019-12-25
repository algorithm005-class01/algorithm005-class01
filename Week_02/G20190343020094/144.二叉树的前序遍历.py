#
# @lc app=leetcode.cn id=144 lang=python3
#
# [144] 二叉树的前序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# class Solution:
#     def preorderTraversal(self, root: TreeNode) -> List[int]:
#         res = []
#         self.helper(root,res)
#         return res        

#     def helper(self, root, res):
#         if root:
#             res.append(root.val)
#             self.helper(root.left, res)
#             self.helper(root.right, res)

class Solution:
    # 思路很清楚，本质上还是递归，只是手动维护了一个调用栈
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        WHITE, GRAY = 0, 1
        res = []
        stack = [(WHITE, root)]
        while stack:
            color, node = stack.pop()
            if node is None: continue
            if color == WHITE:
                stack.append((WHITE, node.right))
                stack.append((WHITE, node.left))
                stack.append((GRAY, node))
            else:
                res.append(node.val)
        return res




# @lc code=end

