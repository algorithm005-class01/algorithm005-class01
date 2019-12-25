from typing import List

from homework.Week_02.NTreeNode import NTreeNode


class Solution(object):

    def levelorder(self, root: NTreeNode) -> List[List[int]]:
        if root is None:
            return []
        result = []
        self.levelorder_helper(root, 0, result)
        return result

    def levelorder_helper(self, root: NTreeNode, depth: int, result: List[List[int]]):
        if root is None:
            return
        if depth + 1 > len(result):
            result.append([])
        result[depth].append(root.val)
        for child in root.children:
            self.levelorder_helper(child, depth + 1, result)
