# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []

        rs = []
        cur_level = [root]
        while cur_level:
            tmp = []
            next_level = []
            for node in cur_level:
                tmp.append(node.val)
                if node.left:
                    next_level.append(node.left)
                if node.right:
                    next_level.append(node.right)
            rs.append(tmp)
            cur_level = next_level
        return rs

    def level_order(self, root):
        rs, level = [], [root]
        while root and level:
            rs.append([node.val for node in level])
            level = [kid for n in level for kid in (n.left, n.right) if kid]
        return rs
