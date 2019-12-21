# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/"""

# Definition for a binary tree node.
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def __init__(self):
        self.inorder_index = {}

    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) != len(inorder):
            return None
        for index, val in enumerate(inorder):
            self.inorder_index[val] = index
        return self._build(preorder, 0, len(preorder) - 1, inorder, 0, len(inorder) - 1)

    def _build(self, preorder, pre_left, pre_right, inorder, in_left, in_right):
        if pre_left > pre_right or in_left > in_right:
            return None
        cur = preorder[pre_left]
        node = TreeNode(cur)
        pivot = self.inorder_index[cur]
        left_count, right_count = pivot - in_left, in_right - pivot
        node.left = self._build(preorder, pre_left + 1, pre_left + left_count, inorder, in_left,
                                in_left + left_count - 1)
        node.right = self._build(preorder, pre_left + left_count + 1, pre_right, inorder, pivot + 1, in_right)
        return node
