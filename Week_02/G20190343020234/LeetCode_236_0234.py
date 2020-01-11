# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def __init__(self):
        self.ans = None
    
    def lowestCommonAncestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        def recursion_tree(current_node):
            if not current_node:
                return False
            
            left = recursion_tree(current_node.left)
            right = recursion_tree(current_node.right)

            mid = current_node == p or current_node == q

            if left + right + mid >= 2:
                self.ans = current_node
            
            return left or right or mid
        
        recursion_tree(root)
        return self.ans
