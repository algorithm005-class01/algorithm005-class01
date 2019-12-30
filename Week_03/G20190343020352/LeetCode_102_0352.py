# Definition for a binary tree node.
from collections import deque
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        result = []
        queue = [root]
        while queue:
            child = []
            nodes = []
            for item in queue:
                nodes.append(item.val)
                if item.left:
                    child.append(item.left)
                if item.right:
                    child.append(item.right)
            result.append(nodes)
            queue = child

        return result
