#您需要在二叉树的每一行中找到最大的值。 
#
# 示例： 
#
# 
#输入: 
#
#          1
#         / \
#        3   2
#       / \   \  
#      5   3   9 
#
#输出: [1, 3, 9]
# 
# Related Topics 树 深度优先搜索 广度优先搜索

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

#leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def largestValues(self, root):

        def dfs(node, level):
            if not node:
                return
            if len(res) == level:
                res.append(node.val)
            else:
                res[level] = max(res[level], node.val)
            dfs(node.left, level + 1)
            dfs(node.right, level + 1)
        res = []
        dfs(root, 0)
        return res

    def largestValues(self, root):
        q, res = [root], []
        while q and root:
            res.append(max([n.val for n in q]))
            q = [kid for n in q for kid in (n.left, n.right) if kid]
        return res

#leetcode submit region end(Prohibit modification and deletion)
