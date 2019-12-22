#解法1，遍历法
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution(object):
    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        res = []
        if root == None:
            return []

        for child in root.children:
            res.extend(self.postorder(child))
        res.append(root.val)
            
        return res

#解法2，迭代法
class Solution(object):
    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        if root is None:
            return []
        stack, res =[root], []

        while stack:
            root = stack.pop()
            if root != None:
                res.append(root.val)
            if root.children:
                for c in root.children:
                    stack.append(c)
            
        return res[::-1]
