# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        # 1. 递归
        #     res = []
        #     self.traversal(root, res)
        #     return res

        # def traversal(self, root, res):
        #     if not root:
        #         return
        #     res.append(root.val)
        #     self.traversal(root.left, res)
        #     self.traversal(root.right, res)

        #     return

        # 2. 模拟调用栈
        # res, stack, cur = [], [], root

        # while cur or stack:
        #     while cur:
        #         res.append(cur.val)
        #         stack.append(cur)
        #         cur = cur.left

        #     cur = stack.pop()
        #     cur = cur.right

        # return res

        # 3. 迭代
        if root is None:
            return []
        res, stack = [], [root]
        while stack:
            cur = stack.pop()
            if cur:
                res.append(cur.val)
                stack.append(cur.right)
                stack.append(cur.left)

        return res