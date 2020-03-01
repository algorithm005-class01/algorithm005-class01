"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution(object):
    def __init__(self):
        self.l = []

    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """

        if root:
            for node in root.children:
                self.postorder(node)

            self.l.append(root.val)

        return self.l