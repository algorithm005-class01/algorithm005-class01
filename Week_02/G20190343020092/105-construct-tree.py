# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#首先，根据前序遍历结果，找到第1个节点就是树的根节点
#其次，中序遍历结果中，以根节点为标记分隔，左侧在左子树，右侧都在右子树
#重复的子问题：每次都先根据前序遍历找到根节点，然后根据中序遍历找到左右子节点
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(inorder) == 0:
            return None
        root = TreeNode(preorder.pop(0))#每次删除队头的时间复杂度，都为O(n)，耗时在这,但是怎么改进呢。。
        bound = inorder.index(root.val)

        root.left = self.buildTree(preorder, inorder[:bound])
        root.right = self.buildTree(preorder, inorder[bound+1:])
        return root
