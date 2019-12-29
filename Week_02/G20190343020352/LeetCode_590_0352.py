from typing import List

from homework.Week_02.NTreeNode import NTreeNode


class Solution(object):

    # 递归
    def posorder_recursion(self, root: NTreeNode) -> List[int]:
        result = []
        if root is None:
            return result
        self.posorder_helper(root, result)
        return result

    def posorder_helper(self, root: NTreeNode, result: List[int]):
        if root is None:
            return
        if root is not None:
            for child in root.children:
                self.posorder_helper(child, result)
            result.append(root.val)

    # stack
    def posorder(self, root: NTreeNode) -> List[int]:
        result = []
        if root is None:
            return result
        stack = [root, ]
        while stack:
            popValue = stack.pop()
            if popValue is not None:
                result.append(popValue.val)
            for child in popValue.children:
                stack.append(child)
        return result[::-1]
