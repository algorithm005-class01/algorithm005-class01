# 98. Validate Binary Search Tree

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        
        # 1.中序遍历完 sorted
        
        # res = []
        # def helper(root):
        #     if not root:
        #         return 
        #     helper(root.left)
        #     res.append(root.val)
        #     helper(root.right)
        # helper(root)
        # return res == sorted(res) and len(set(res)) == len(res)
        
        # 2.中序遍历 借助 prev
        
        self.prev = None
        def helper(node):
            if not node:
                return True
            if not helper(node.left):
                return False
            if self.prev and self.prev.val >= node.val:
                return False
            self.prev = node
            return helper(node.right)
        
        return helper(root)
        
        # 3.利用最大值，最小值 lower upper
        
#         def helper(node, lower = float("-inf"), upper = float("inf")):
#             if not node:
#                 return True
            
#             val = node.val
#             if val <= lower or val >= upper:
#                 return False
            
#             if not helper(node.left, lower, val):
#                 return False
#             if not helper(node.right, val, upper):
#                 return False
            
#             return True
        
#         return helper(root)