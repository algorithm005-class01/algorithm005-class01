"""590. N-ary Tree Postorder Traversal

Given an n-ary tree, return the postorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).

 

Follow up:

Recursive solution is trivial, could you do it iteratively?
"""


# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution(object):
    def __init__(self):
        self.traverse_path = []

    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        if root:
            for i in root.children:
                self.postorder(i)
            self.traverse_path.append(root.val)
        return self.traverse_path