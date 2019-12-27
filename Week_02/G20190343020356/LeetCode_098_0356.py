# -*- coding: utf-8 -*-
"""https://leetcode-cn.com/problems/validate-binary-search-tree/"""


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        stack, pre_val = [], float('-inf')
        cur = root
        while cur or stack:
            while cur:
                stack.append(cur)
                cur = cur.left
            temp = stack.pop()
            if temp.val <= pre_val:
                return False
            pre_val = temp.val
            cur = temp.right
        return True
