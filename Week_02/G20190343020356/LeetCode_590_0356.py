# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal"""
from typing import List


# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    """
    例如三叉树后序遍历:左中右根
    其逆序为:根右中左
    可以先根据 调整前序遍历的子节点入栈顺序 而得到'根右中左'的序列,再将其逆序
    """

    def postorder(self, root: 'Node') -> List[int]:
        if not root:
            return []
        res = []
        stack = [root]
        while stack:
            cur = stack.pop()
            res.append(cur.val)
            stack.extend(cur.children)
        return res[::-1]
