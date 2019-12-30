# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/binary-tree-level-order-traversal/"""
from typing import List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# 二叉树层次遍历递归与非递归
class Solution:
    # 非递归
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        res = []
        que = [root]
        while que:
            size = len(que)
            temp = []
            for _ in range(size):
                cur = que.pop(0)
                temp.append(cur.val)
                if cur.left:
                    que.append(cur.left)
                if cur.right:
                    que.append(cur.right)
            res.append(temp)
        return res

    # 递归
    def levelOrderTwo(self, root: TreeNode) -> List[List[int]]:
        res = []

        def _help(root, level):
            if root:
                if len(res) - 1 < level:
                    res.append([])
                res[level].append(root.val)
                _help(root.left, level + 1)
                _help(root.right, level + 1)

        _help(root, 0)
        return res
