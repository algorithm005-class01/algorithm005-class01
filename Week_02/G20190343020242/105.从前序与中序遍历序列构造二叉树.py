#
# @lc app=leetcode.cn id=105 lang=python3
#
# [105] 从前序与中序遍历序列构造二叉树
#
# https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
#
# algorithms
# Medium (62.93%)
# Likes:    289
# Dislikes: 0
# Total Accepted:    34.2K
# Total Submissions: 54.3K
# Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
#
# 根据一棵树的前序遍历与中序遍历构造二叉树。
# 
# 注意:
# 你可以假设树中没有重复的元素。
# 
# 例如，给出
# 
# 前序遍历 preorder = [3,9,20,15,7]
# 中序遍历 inorder = [9,3,15,20,7]
# 
# 返回如下的二叉树：
# 
# ⁠   3
# ⁠  / \
# ⁠ 9  20
# ⁠   /  \
# ⁠  15   7
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
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        # preorder 中任一节点 root
        # inorder 中对应的 root 节点左边所有节点组成 root.left,  右边节点组成 root.right

        pre_idx = 0
        idx_map = {val:idx for idx, val in enumerate(inorder)} 

        def helper(in_left = 0, in_right = len(inorder)):
            nonlocal pre_idx
            if in_left == in_right:
                return None
            
            # preorder 中节点为 root
            root_val = preorder[pre_idx]
            root = TreeNode(root_val)

            # inorder 中对应 root 节点左边所有节点为 root.left, 右边所有节点为 root.right
            index = idx_map[root_val]
            pre_idx += 1    # 递归栈每一层都依次确定一个 root 元素
            root.left = helper(in_left, index)
            root.right = helper(index + 1, in_right)
            return root
        
        return helper()

        
# @lc code=end

