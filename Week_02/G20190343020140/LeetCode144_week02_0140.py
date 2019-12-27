#解法1 迭代法 栈
class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res,stack =[],[root]
        while stack:                  #根节点不为空
            node = stack.pop()      

            if node:
                res.append(node.val)
                stack.append(node.right)
                stack.append(node.left)
        return res

#解法2 遍历法
class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        res = []
        if root:
            res.append(root.val)
            res += self.preorderTraversal(root.left)
            res += self.preorderTraversal(root.right)
        return res
