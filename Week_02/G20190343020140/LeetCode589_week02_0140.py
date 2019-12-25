#解法1：栈的办法，逆转子孩子的顺序，根左右，根先存入list, 栈先压右孩子，再压左孩子
"""
# Definition for a Node.
class Node(object):
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution(object):
    def preorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        if not root:
            return []

        stack = [root]
        res = []
        while stack:
            
            cur = stack.pop()
            res.append(cur.val)
            if cur.children:
                for child in cur.children[::-1]:   #先压最右，再压左
                    stack.append(child)
            
        return res

#解法2 遍历：根左右
class Solution(object):
    def preorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        if not root:
            return []

        res = []
        if root:
            res.append(root.val)
            if root.children:
                for child in root.children:
                    res += self.preorder(child)
        return res
