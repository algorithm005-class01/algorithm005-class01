# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def constructFromPrePost(self, pre, post):
        """
        :type pre: List[int]
        :type post: List[int]
        :rtype: TreeNode
        """
        if not pre:
            return None
        root = TreeNode(pre[0])
        if len(pre) == 1:
            return root
        
        left_len = post.index(pre[1]) + 1
        root.left = self.constructFromPrePost(pre[1:left_len+1], post[:left_len])
        root.right = self.constructFromPrePost(pre[left_len+1:], post[left_len:-1])
        return root
        