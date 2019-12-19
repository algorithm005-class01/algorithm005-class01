# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

#递归解法
# class Solution:
#     def inorderTraversal(self, root: TreeNode) -> List[int]:
#         result = []
#         self.helper(root, result)
#         return result

#     def helper(self, root, result):
#         if not root: return
        
#         if root.left: self.helper(root.left, result)
#         result.append(root.val)
#         if root.right: self.helper(root.right, result)

#迭代解法
class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        stack = []
        pointer = root
        
        #写得挺巧妙的，多看几遍
        while pointer or stack:#当pointer不是NoneType或者stack不为空时：
            while pointer:
                stack.append(pointer)#遍历左儿子并压入栈
                pointer = pointer.left
            
            pointer = stack.pop()#遍历完后，pointer是NoneType，要先赋值给他， 让他回到最左边的叶子节点
            result.append(pointer.val)
            pointer = pointer.right
        
        return result
