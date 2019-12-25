# -*- coding: utf-8 -*-
# @Time    : 2019-12-20 17:00
# @Author  : songzhenxi
# @Email   : songzx_2326@163.com
# @File    : LeetCode_94_1034.py
# @Software: PyCharm

# 给定一个二叉树，返回它的中序 遍历。
#
# 示例:
#
# 输入: [1,null,2,3]
#   1
#    \
#     2
#    /
#   3
#
# 输出: [1,3,2]
#
# 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
# Related Topics 栈 树 哈希表


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def inorderTraversal(self, root):
        """
        题目：94.二叉树的中序遍历（https://leetcode-cn.com/problems/binary-tree-inorder-traversal/）
        学号：1034（五期一班三组）
        标签：树 递归
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        self.helper(root, res)
        return res

    def helper(self, tree, res):
        if tree is None:
            return
        self.helper(tree.left, res)
        res.append(tree.val)
        self.helper(tree.right, res)
# leetcode submit region end(Prohibit modification and deletion)
