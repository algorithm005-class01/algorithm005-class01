from typing import List

from homework.Week_02.NTreeNode import NTreeNode


class Solution(object):

    def preorder(self, root: NTreeNode) -> List[int]:
        result = []
        if root is None:
            return result
        stack = [root, ]
        while stack:
            popValue = stack.pop()
            result.append(popValue.val)
            stack.extend(popValue.children[::-1])
        return result

    def preorder_recursion(self, root: NTreeNode) -> List[int]:
        result = []
        if root is None:
            return result
        self.preorder_helper(root, result)
        return result

    def preorder_helper(self, root: NTreeNode, result: List[int]):
        if root is None:
            return
        else:
            result.append(root.val)
            if root.children is not None:
                for child in root.children:
                    self.preorder_helper(child, result)
