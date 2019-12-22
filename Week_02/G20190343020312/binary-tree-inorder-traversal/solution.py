class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

class Solution:
    def inorderTraversal(self, root):
        WHITE, GRAY = 0, 1
        result = []
        stack = [(WHITE, root)]
        while stack:
            color, node = stack.pop()
            if node:
                if color == WHITE:
                    stack.append((WHITE, node.right))
                    stack.append((GRAY, node))
                    stack.append((WHITE, node.left))
                else:
                    result.append(node.val)
        return result

