from typing import List

from homework.Week_02.TreeNode import TreeNode


class Solution(object):

    # stack
    def preorder(self, root: TreeNode) -> List[int]:
        WHITE, BLACK = 0, 1
        result = []
        storeStack = [(WHITE, root)]
        while storeStack:
            color, node = storeStack.pop()
            if node is None:
                continue
            if color == WHITE:
                storeStack.append((WHITE, node.right))
                storeStack.append((WHITE, node.left))
                storeStack.append((BLACK, node))
            else:
                result.append(node.val)
        return result

    # 递归
    def preorder_recursion(self, root: TreeNode) -> List[int]:
        result = []
        self.preorder_helper(root, result)
        return result

    def preorder_helper(self, root: TreeNode, result: List[int]) -> List[int]:
        if root is not None:
            result.append(root.val)
            if root.left is not None:
                self.preorder_helper(root.left, result)
            if root.right is not None:
                self.preorder_helper(root.right, result)

