# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#递归
# class Solution:
#     def preorderTraversal(self, root: TreeNode) -> List[int]:
#         result = []
#         def helper(root, result):
#             if not root: return
#             result.append(root.val)
#             if root.left:
#                 helper(root.left, result)
#             if root.right:
#                 helper(root.right, result)
        
#         helper(root, result)
#         return result

#迭代
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        if not root: return result
        pointer = root
        stack = [pointer]
        while stack:
            cur = stack.pop()
            result.append(cur.val)
            #这里要注意，是右先入栈，左再入栈，使得pop时，左先出，右再出
            if cur.right:
                stack.append(cur.right)
            if cur.left:
                stack.append(cur.left)
        return result
            
