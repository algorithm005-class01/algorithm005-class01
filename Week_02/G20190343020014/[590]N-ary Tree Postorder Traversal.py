#给定一个 N 叉树，返回其节点值的后序遍历。 
#
# 例如，给定一个 3叉树 : 
#
# 
#
# 
#
# 
#
# 返回其后序遍历: [5,6,3,2,4,1]. 
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
    def postorder1(self, root: 'Node') -> List[int]:
        res = []
        self._recursion(root, res)
        return res

    def _recursion(self, node, res):
        # 左 -> 右 -> 根

        # 终止条件
        if not node:
            return

        # drill down
        for c in node.children:
            self._recursion(c, res)

        # current status
        res.append(node.val)

    def postorder(self, root: 'Node') -> List[int]:
        stack, res = [], []
        if not root: return res
        stack.append(root)
        while stack:
            root = stack.pop()
            res.append(root.val)
            if root.children:
                for i in root.children:
                    stack.append(i)
        return reversed(res)

#leetcode submit region end(Prohibit modification and deletion)
