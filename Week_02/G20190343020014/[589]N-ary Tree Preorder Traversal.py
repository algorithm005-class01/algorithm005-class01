#给定一个 N 叉树，返回其节点值的前序遍历。 
#
# 例如，给定一个 3叉树 : 
#
# 
#
# 
#
# 
#
# 返回其前序遍历: [1,3,5,6,2,4]。 
#
# 
#
# 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树



#leetcode submit region begin(Prohibit modification and deletion)
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def preorder1(self, root: 'Node') -> List[int]:
        res = []
        self._recursion(root, res)
        return res

    def _recursion(self, node, res):
        # 根 左 右
        if not node:
            return
        res.append(node.val)
        if node.children:
            for i in node.children:
                self._recursion(i, res)


    def preorder(self, root: 'Node') -> List[int]:
        stack, res = [root], []
        if not root: return res
        while stack:
            root = stack.pop()
            res.append(root.val)
            if root.children:
                for i in reversed(root.children):
                    stack.append(i)
        return res
        
#leetcode submit region end(Prohibit modification and deletion)
