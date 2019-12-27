from typing import List

from homework.Week_02.TreeNode import TreeNode


class Solution(object):

    # stack
    def inorder(self, root: TreeNode) -> List[int]:
        WHITE, GRAY = 0, 1
        ressult = []
        stack = [(WHITE, root)]
        while stack:
            color, node = stack.pop()
            if node is None:
                continue
            if color == WHITE:
                stack.append((WHITE, node.right))
                stack.append((GRAY, node))
                stack.append((WHITE, node.left))
            else:
                ressult.append(node.val)
        return ressult

    # 递归
    def inorder_recursion(self, root: TreeNode) -> List[int]:
        result = []
        self.inorder_helper(root, result)
        return result

    def inorder_helper(self, root: TreeNode, result: List[int]) -> List[int]:
        if root is not None:
            if root.left is not None:
                self.inorder_helper(root.left, result)
            result.append(root.val)
            if root.right is not None:
                self.inorder_helper(root.right, result)
