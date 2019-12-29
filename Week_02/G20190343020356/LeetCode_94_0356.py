# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/binary-tree-inorder-traversal"""


# Definition for a binary tree node.
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def inorder_recur(self, root: TreeNode) -> List[int]:
        res = []
        self.in_order(root, res)
        return res

    def in_order(self, root, res):
        if root:
            self.in_order(root.left, res)
            res.append(root.val)
            self.in_order(root.right, res)

    def inorder_non_recur(self, root: TreeNode) -> List[int]:
        res = []
        stack = []
        cur = root
        while cur or stack:
            while cur:
                stack.append(cur)
                cur = cur.left
            temp = stack.pop()
            res.append(temp.val)
            cur = temp.right
        return res
