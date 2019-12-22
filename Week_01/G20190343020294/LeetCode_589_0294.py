"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        # if not root:
        #     return []

        # stack, res = [root], []
        # while stack:
        #     cur = stack.pop()
        #     res.append(cur.val)
        #     stack.extend(cur.children[::-1])

        # return res

        # 2.
        if not root:
            return []

        res = []
        self.help(root, res)
        return res

    def help(self, root, res):
        res.append(root.val)
        for i in root.children:
            self.help(i, res)