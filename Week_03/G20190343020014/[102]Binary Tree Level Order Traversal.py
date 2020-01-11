#给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。 
#
# 例如: 
#给定二叉树: [3,9,20,null,null,15,7], 
#
#     3
#   / \
#  9  20
#    /  \
#   15   7
# 
#
# 返回其层次遍历结果： 
#
# [
#  [3],
#  [9,20],
#  [15,7]
#]
# 
# Related Topics 树 广度优先搜索

from typing import List
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


def stringToTreeNode(input):
    input = input.strip()
    input = input[1:-1]
    if not input:
        return None

    inputValues = [s.strip() for s in input.split(',')]
    root = TreeNode(int(inputValues[0]))
    nodeQueue = [root]
    front = 0
    index = 1
    while index < len(inputValues):
        node = nodeQueue[front]
        front = front + 1

        item = inputValues[index]
        index = index + 1
        if item != "None":
            leftNumber = int(item)
            node.left = TreeNode(leftNumber)
            nodeQueue.append(node.left)

        if index >= len(inputValues):
            break

        item = inputValues[index]
        index = index + 1
        if item != "None":
            rightNumber = int(item)
            node.right = TreeNode(rightNumber)
            nodeQueue.append(node.right)
    return root

#leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def levelOrder1(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        q, res = [root], []
        while q:
            res.append([node.val for node in q])

            q1 = []
            for node in q:
                if node.left:
                    q1.append(node.left)
                if node.right:
                    q1.append(node.right)
            q = q1
        return res

    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        q, res = [root], []
        while root and q:
            res.append([node.val for node in q])
            # children = [(node.left, node.right) for node in q]
            # q = [kid for c in children for kid in c if kid]
            q = [child for node in q for child in (node.left, node.right) if child]
        return res

    def levelOrder2(self, root: TreeNode) -> List[List[int]]:
        res = []

        def _dfs(root, height):
            # terminate
            if not root:
                return
            # process current level
            if len(res) == height:
                res.append([])
            res[height].append(root.val)

            # dirll down
            _dfs(root.left, height + 1)
            _dfs(root.right, height + 1)

        _dfs(root, 0)
        return res
#leetcode submit region end(Prohibit modification and deletion)

x = Solution().levelOrder(stringToTreeNode(str([1,2,3,4, None, None, 5])))

print(x)