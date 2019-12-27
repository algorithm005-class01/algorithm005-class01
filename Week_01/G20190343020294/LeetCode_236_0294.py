# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        # 1.
        # # 1. left leaf == p/q                               
        # # 2. right leaf == p/q                             
        # # 3. root == p/q                                  
        # self.ans = None
        # self.help(root, p, q)
        # return self.ans




        # 2.
        # if root in (None, p, q):
        #     return root

        # left = self.lowestCommonAncestor(root.left, p, q)
        # right = self.lowestCommonAncestor(root.right, p, q)

        # return root if left and right else left or right



        # 3.
        if not root:
            return root

        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)

        if root == p or root == q:
            return root
            
            
        return root if left and right else left or right

    # 1. 
    # def help(self, root, p, q):
    #     if not root:
    #         return False

    #     left = self.help(root.left, p, q)
    #     right = self.help(root.right, p, q)

    #     mid = True if root == p or root == q else False
            
    #     if sum(map(lambda x: x and 1 or 0, [left, right, mid])) >= 2:
    #         self.ans = root
            
    #     if any([left, right, mid]):
    #         return True

