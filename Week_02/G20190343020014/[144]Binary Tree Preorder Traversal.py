#给定一个二叉树，返回它的 前序 遍历。 
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
#输出: [1,2,3]
# 
#
# 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
# Related Topics 栈 树



#leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # result = []

    # def preorderTraversal(self, root: TreeNode) -> List[int]:
    #     if not root:
    #         return

    #     self.result.append(root.val)
    #     if root.left:
    #         self.preorderTraversal(root.left)
    #     if root.right:
    #         self.preorderTraversal(root.right)
    #     return self.result
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        stack, result = [], []
        if not root:
            return result

        stack.append(root)
        while stack:
            temp = stack.pop()
            result.append(temp.val)
            if temp.right:
                stack.append(temp.right)
            if temp.left:
                stack.append(temp.left)
        return result


        
#leetcode submit region end(Prohibit modification and deletion)
