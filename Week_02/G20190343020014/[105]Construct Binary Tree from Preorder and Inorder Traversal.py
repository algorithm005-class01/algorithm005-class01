#根据一棵树的前序遍历与中序遍历构造二叉树。 
#
# 注意: 
#你可以假设树中没有重复的元素。 
#
# 例如，给出 
#
# 前序遍历 preorder = [3,9,20,15,7]
#中序遍历 inorder = [9,3,15,20,7] 
#
# 返回如下的二叉树： 
#
#     3
#   / \
#  9  20
#    /  \
#   15   7 
# Related Topics 树 深度优先搜索 数组



#leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """

        def helper(in_left=0, in_right=len(inorder)):
            nonlocal pre_idx
            if in_left == in_right:
                return None

            root_val = preorder[pre_idx]
            root = TreeNode(root_val)

            index = idx_map[root_val]

            pre_idx += 1
            root.left = helper(in_left, index)
            root.right = helper(index + 1, in_right)
            return root

        pre_idx = 0
        idx_map = {val: idx for idx, val in enumerate(inorder)}
        return helper()


#leetcode submit region end(Prohibit modification and deletion)
