#
# @lc app=leetcode.cn id=94 lang=python3
#
# [94] 二叉树的中序遍历
#
# https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
#
# algorithms
# Medium (69.12%)
# Likes:    340
# Dislikes: 0
# Total Accepted:    84.3K
# Total Submissions: 121.8K
# Testcase Example:  '[1,null,2,3]'
#
# 给定一个二叉树，返回它的中序 遍历。
# 
# 示例:
# 
# 输入: [1,null,2,3]
# ⁠  1
# ⁠   \
# ⁠    2
# ⁠   /
# ⁠  3
# 
# 输出: [1,3,2]
# 
# 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
# 
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        # 1.递归
        # res = []
        # if root:
        #     res.extend(self.inorderTraversal(root.left))
        #     res.append(root.val)
        #     res.extend(self.inorderTraversal(root.right))
        # return res
        
        # 2.基于栈的遍历
        # TODO:
        # 将最左节点加入栈中，然后依次弹出检查其右节点
        res = []
        stack = []
        cur = root
        while cur or stack:
            while cur:
                stack.append(cur)   # 每个节点，首先访问其最左边的叶子节点
                cur = cur.left      # 将叶子节点置于栈顶
            cur = stack.pop()
            res.append(cur.val)     # 访问根节点
            cur = cur.right         # 当前右子树
        return res

        # 3.树节点带状态
        # TODO：
        # PENDING, DONE = 0,1
        # res = []
        # stack = [(PENDING, root)]
        # while stack:
        #     state, node = stack.pop()
        #     if not node:
        #         continue
        #     if state == PENDING:
        #         stack.append((PENDING, node.right))
        #         stack.append((DONE, node))
        #         stack.append((PENDING, node.left))
        #     else:
        #         res.append(node.val)
        # return res

# @lc code=end

