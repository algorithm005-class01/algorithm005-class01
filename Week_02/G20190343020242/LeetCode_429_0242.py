#
# @lc app=leetcode.cn id=429 lang=python3
#
# [429] N叉树的层序遍历
#
# https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/description/
#
# algorithms
# Medium (63.52%)
# Likes:    64
# Dislikes: 0
# Total Accepted:    12.2K
# Total Submissions: 19.2K
# Testcase Example:  '[1,null,3,2,4,null,5,6]\r'
#
# 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
#
# 例如，给定一个 3叉树 :
#
#
#
#
#
#
#
# 返回其层序遍历:
#
# [
# ⁠    [1],
# ⁠    [3,2,4],
# ⁠    [5,6]
# ]
#
#
#
#
# 说明:
#
#
# 树的深度不会超过 1000。
# 树的节点总数不会超过 5000。
#
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        q, res = [root], []
        while any(q):
            res.append([node.val for node in q])
            q = [child for node in q for child in node.children if child]
        return res


# @lc code=end
