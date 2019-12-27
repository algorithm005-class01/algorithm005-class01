"""104. Maximum Depth of Binary Tree

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
"""


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    def max_depth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        时间复杂度: O(N), 每个节点都访问一次
        空间复杂度：最坏 O(N)，只有左子树或右子树，最好 O(lgN), 二叉树完全平衡
        """
        return 1+ max(map(self.max_depth, (root.left, root.right))) if root else 0

    def max_depth2(self, root):
        """可读性好点
        """
        if not root:
            return 0
        left_depth = self.max_depth2(root.left)
        right_depth = self.max_depth2(root.right)
        return max(left_depth, right_depth) + 1