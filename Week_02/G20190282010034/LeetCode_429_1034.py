# -*- coding: utf-8 -*-
# @Time    : 2019-12-20 17:24
# @Author  : songzhenxi
# @Email   : songzx_2326@163.com
# @File    : LeetCode_429_1034.py
# @Software: PyCharm

# 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
#
# 例如，给定一个 3叉树 :
#
# 返回其层序遍历:
#
# [
#     [1],
#     [3,2,4],
#     [5,6]
# ]
#
# 说明:
#
#
# 树的深度不会超过 1000。
# 树的节点总数不会超过 5000。
# Related Topics 树 广度优先搜索


# leetcode submit region begin(Prohibit modification and deletion)
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution(object):
    def levelOrder(self, root):
        """
        题目：429.N叉树的层序遍历（https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/）
        学号：1034（五期一班三组）
        :type root: Node
        :rtype: List[List[int]]
        """
        res = []
        self.helper(root, res, 0)
        return res

    def helper(self, tree, res, level):
        if tree is None:
            return
        if level >= len(res):
            res.append([])
        res[level].append(tree.val)
        if tree.children:
            for child in tree.children:
                self.helper(child, res, level + 1)
# leetcode submit region end(Prohibit modification and deletion)
