#
# @lc app=leetcode.cn id=590 lang=python3
#
# [590] N叉树的后序遍历
#
# https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
#
# algorithms
# Easy (70.92%)
# Likes:    39
# Dislikes: 0
# Total Accepted:    12.7K
# Total Submissions: 17.9K
# Testcase Example:  '[1,null,3,2,4,null,5,6]\r'
#
# 给定一个 N 叉树，返回其节点值的后序遍历。
# 
# 例如，给定一个 3叉树 :
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
# 说明: 递归法很简单，你可以使用迭代法完成此题吗?
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
    def postorder(self, root: 'Node') -> List[int]:
        # # 1. 递归
        # res = []
        # if root:
        #     if root.children:
        #         for child in root.children:
        #             res.extend(self.postorder(child))
        #     res.append(root.val)
        # return res

        # 2. 栈
        if root is None:
            return []
        res,stack = [],[root]
        while stack:
            curr = stack.pop()
            if curr is not None:
                res.append(curr.val)
            for c in curr.children:
                stack.append(c)
        return res[::-1]





        
# @lc code=end

