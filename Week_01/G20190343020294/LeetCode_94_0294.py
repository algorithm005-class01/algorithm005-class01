# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        # 1.
        # res = []
        # if not root:
        #     return []

        # res.extend(self.inorderTraversal(root.left))
        # res.append(root.val)
        # res.extend(self.inorderTraversal(root.right))

        # return res

        # 2.
        # 优化，空叶子无需递归
        # res = []
        # if not root:
        #     return []

        # if root.left:
        #     res.extend(self.inorderTraversal(root.left))
        # res.append(root.val)
        # if root.right:
        #     res.extend(self.inorderTraversal(root.right))

        # return res

        # 3.
        # 地址传递， 不需要每次都开辟list
        # 对于这道题的测试， 虽然这种方法耗时更多了， 但是当树较大时应该更快
        #     res = []
        #     self.traveral(root, res)

        #     return res

        # def traveral(self, root, res):
        #     if not root:
        #         return
        #     if root.left:
        #         self.traveral(root.left, res)
        #     res.append(root.val)
        #     if root.right:
        #         self.traveral(root.right, res)

        # 4.
        # 模拟调用栈
        res = []
        stack = []
        cur = root
        while stack or cur:
            while cur:
                stack.append(cur)
                cur = cur.left
            cur = stack.pop()
            res.append(cur.val)
            cur = cur.right

        return res


