# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/binary-tree-preorder-traversal/"""


# Definition for a binary tree node.
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def preorderTraversalOne(self, root: TreeNode) -> List[int]:
        res = []
        stack = []
        cur = root
        while cur or stack:
            while cur:
                res.append(cur.val)
                stack.append(cur)
                cur = cur.left
            temp = stack.pop()
            cur = temp.right
        return res

    def preorderTraversalTwo(self, root: TreeNode) -> List[int]:
        res = []
        stack = []
        if root:
            stack.append(root)
            while stack:
                cur = stack.pop()
                res.append(cur.val)
                if cur.right:
                    stack.append(cur.right)
                if cur.left:
                    stack.append(cur.left)
        return res
