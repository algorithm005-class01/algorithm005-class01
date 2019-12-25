# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    # 和求最大深度有点不一样的深度是:求最小深度需要判断一下左节点或者右节点是否为null
    # 因为如果根的左节点或者右节点为null，是不满足根到叶子节点这个定义的
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        left_dep = self.minDepth(root.left)
        right_dep = self.minDepth(root.right)
        if left_dep == 0 or right_dep == 0:
            return left_dep + right_dep + 1
        return min(left_dep, right_dep) + 1
