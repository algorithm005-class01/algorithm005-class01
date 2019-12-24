#
# @lc app=leetcode.cn id=94 lang=python3
#
# [94] 二叉树的中序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# class Solution:
#     def inorderTraversal(self, root: TreeNode) -> List[int]:
#         val = []
#         self.helper(root,val)
#         return val

        
#     def helper(self, root: TreeNode, res: List[int]) -> List[int]:
#         if root:
#             self.helper(root.left, res)
#             res.append(root.val)
#             self.helper(root.right, res)

# class Solution:
#     def inorderTraversal(self, root: TreeNode) -> List[int]:
#         val = []
#         stack = []
#         curr = root
#         while curr != None or len(stack) > 0:
#             while curr != None:
#                 stack.append(curr)
#                 curr = curr.left
#             curr = stack.pop()
#             val.append(curr.val)
#             curr = curr.right
#         return val

# class Solution:
#     def inorderTraversal(self, root: TreeNode) -> List[int]:
#         res = []
#         curr = root
#         while curr != None:
#             if curr.left == None:
#                 res.append(curr.val)
#                 curr = curr.right
#             else:
#                 pre = curr.left
#                 while pre.right != None:
#                     pre = pre.right
#                 pre.right = curr
#                 temp = curr
#                 curr = curr.left
#                 temp.left = None
#         return res


class Solution:
    # 思路很清楚，本质上还是递归，只是手动维护了一个调用栈
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        WHITE, GRAY = 0, 1
        res = []
        stack = [(WHITE, root)]
        while stack:
            color, node = stack.pop()
            if node is None: continue
            if color == WHITE:
                stack.append((WHITE, node.right))
                stack.append((GRAY, node))
                stack.append((WHITE, node.left))
            else:
                res.append(node.val)
        return res


# @lc code=end

