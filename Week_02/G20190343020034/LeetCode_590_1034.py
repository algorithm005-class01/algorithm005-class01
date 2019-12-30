# -*- coding: utf-8 -*-
# @Time    : 2019-12-20 17:13
# @Author  : songzhenxi
# @Email   : songzx_2326@163.com
# @File    : LeetCode_590_1034.py
# @Software: PyCharm

# 给定一个 N 叉树，返回其节点值的后序遍历。
#
# 例如，给定一个 3叉树 :
#
#
#
#
#
#
#
# 返回其后序遍历: [5,6,3,2,4,1].
#
#
#
# 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


# leetcode submit region begin(Prohibit modification and deletion)
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution(object):
    def postorder(self, root):
        """
        题目：590.N叉树的后序遍历（https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/）
        学号：1034（五期一班三组）
        标签：树 递归
        :type root: Node
        :rtype: List[int]
        """
        res = []
        self.helper(root, res)
        return res

    def helper(self, tree, res):
        if tree is None:
            return
        if tree.children:
            for child in tree.children:
                self.helper(child, res)
        res.append(tree.val)
# leetcode submit region end(Prohibit modification and deletion)
