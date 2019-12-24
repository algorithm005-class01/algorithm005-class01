"""226. Invert Binary Tree

Invert a binary tree.
"""

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):

    def invert_tree_by_post_order(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        post order

        Apparently, all three order work for this problem by recursion but only post-order version can be compressed into one line
        """
        if root:
            root.left, root.right = self.invertTree(root.right), self.invertTree(root.left)
            return root

    def invert_tree_by_pre_order(self, root):
        if root:
            root.left, root.right = root.right, root.left
            self.invert_tree_by_post_order(root.left)
            self.invert_tree_by_post_order(root.right)
        return root

    def invert_tree_by_in_order(self, root):
        if root:
            self.invert_tree_by_in_order(root.left)
            root.left, root.right = root.right, root.left
            # 注意传参 left 和 right 已经换成交换
            self.invert_tree_by_in_order(root.left)
        return root

    def invert_tree_by_iter(self);
        stack = [root]
        while stack:
            node = stack.pop()
            if node:
                node.left, node.right = node.right, node.left
                if node.left:
                    stack.append(node.left)
                if node.right:
                    stack.append(node.right)
        return root