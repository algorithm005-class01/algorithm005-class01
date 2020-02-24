from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return None
        queue = [root]
        result = []
        while queue:
            children = []
            values = []
            for node in queue:
                if not node:
                    continue
                values.append(node.val)
                if node.left:
                    children.append(node.left)
                if node.right:
                    children.append(node.right)
            result.append(values)
            queue = children
        return result

            
            

