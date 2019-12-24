from homework.Week_02.TreeNode import TreeNode


class Solution(object):

    def __init__(self):
        self.ancestor = None

    def recursion(self, currentNode: TreeNode, p: TreeNode, q: TreeNode):
        if not currentNode:
            return False
        left = self.recursion(currentNode.left, p, q)
        right = self.recursion(currentNode.right, p, q)
        mid = currentNode == p or currentNode == q
        if mid + left + right >= 2:
            self.ancestor = currentNode
        return mid or left or right

    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode):
        self.recursion(root, p, q)
        return self.ancestor
