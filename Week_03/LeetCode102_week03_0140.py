#解法1 DFS, 但是存储了节点的层次信息，剩下的是DFS的模板
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
        levels = []
        if not root:
            return levels

        def helper(node,level):
            if len(levels) == level:
                levels.append([])
            levels[level].append(node.val)
            if node.left:
                helper(node.left,level+1)
            if node.right:
                helper(node.right,level+1)
        helper(root,0)
        return levels

#解法2 BFS, 但是用deque实现的
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
        from collections import deque
        levels = []
        if not root:
            return levels
        level,queue = 0, deque([root])
        while queue:
            levels.append([])
            level_lenth = len(queue)
            for i in range(level_lenth):
                node = queue.popleft()
                levels[level].append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            level += 1 
        return levels

#解法3 用语法糖实现 DFS
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        ans,level = [],[root]
        while root and level:
            ans.append([node.val for node in level])
            LRpair =[(node.left,node.right) for node in level]
            level = [leaf for LR in LRpair for leaf in LR if leaf]
            
        return ans
