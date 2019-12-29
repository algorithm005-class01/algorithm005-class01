#!/user/bin/python
#-*- coding:utf-8 -*-

import collections
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

from typing import List
#Given preorder and inorder traversal of a tree, construct the binary tree.
class Solution:
    def convertTreeToArrayInOrder(self, root: TreeNode) -> List[int]:
        self.result = []
        self.traverseInOrder(root)
        return self.result

    def traverseInOrder(self, root: TreeNode):
        if not root: return
        self.traverseInOrder(root.left)
        self.result.append(root.val)
        self.traverseInOrder(root.right)

    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder: return None

        root = TreeNode(preorder[0])
        if len(preorder) == 1: return root

        pos = inorder.index(preorder[0])
        leftInorder, rightInorder = inorder[0:pos], inorder[pos+1:]
        leftPreOrder, rightPreOrder = preorder[1:len(leftInorder)+1], preorder[len(leftInorder)+1:]

        root.left = self.buildTree(leftPreOrder, leftInorder)
        root.right = self.buildTree(rightPreOrder, rightInorder)
        return root

    # when excute left, the left preorder is removed, this is the key
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if inorder:
            ind = inorder.index(preorder.pop(0))
            root = TreeNode(inorder[ind])
            root.left = self.buildTree(preorder, inorder[0:ind])
            root.right = self.buildTree(preorder, inorder[ind+1:])
            return root



    def buildTree_recursion(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not preorder: return None
        val = preorder[0]
        index = inorder.index(val)
        root = TreeNode(val)
        root.left = self.buildTree_recursion(preorder[1:], inorder[0:index])
        root.right = self.buildTree_recursion(preorder[index+1:], inorder[index+1:])
        return root


import unittest
class SolutionTest(unittest.TestCase):
    def testSolution(self):
        solution = Solution()
        #preorder = [3,9,20,15,7]
        #inorder = [9,3,15,20,7]
        preorder = [1,2]
        inorder = [2,1]        
#        self.assertTrue(solution.convertTreeToArrayInOrder(solution.buildTree(preorder, inorder)) == inorder)
        self.assertTrue(solution.convertTreeToArrayInOrder(solution.buildTree_recursion(preorder, inorder)) == inorder)

if __name__ == "__main__" : unittest.main()
