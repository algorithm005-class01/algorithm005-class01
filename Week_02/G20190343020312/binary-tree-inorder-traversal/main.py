from solution import Solution
from solution import TreeNode
t1 = TreeNode(1)
t2 = TreeNode(None)
t3 = TreeNode(2)
t4 = TreeNode(3)
root = t1
#t1.left = t2
t1.right = t3
t3.left = t4
s = Solution()
print(s.inorderTraversal(root))
