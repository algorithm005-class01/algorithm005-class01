# 102. Binary Tree Level Order Traversal

from collections import deque
# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """

        # 1. DFS
        # def dfs(node, level):
        #     # terminator
        #     if len(levels) == level:
        #         levels.append([])

        #     levels[level].append(node.val)

        #     if node.left:
        #         dfs(node.left, level+1)
        #     if node.right:
        #         dfs(node.right, level+1)
        
        # levels = []
        # if root:
        #     dfs(root, 0)
        # return levels

        # 2. BFS
        levels = []
        if not root:
            return levels

        queue = deque([root,])
        level = 0

        while queue:
            levels.append([])
            level_length = len(queue)

            for i in range(level_length):
                node = queue.popleft()
                levels[level].append(node)

                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            level += 1

        return levels