package main

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type TreeNode struct {
	     Val int
	     Left *TreeNode
	     Right *TreeNode
	 }

func inorderTraversal(t *TreeNode) (result []int) {
	if t == nil {
		return nil
	}

	if t.Left == nil {
		result = append(result,t.Val)
		result = append(result,inorderTraversal(t.Right)...)
		return
	}

	result = append(result, inorderTraversal(t.Left)...)
	result = append(result,t.Val)

	if t.Right == nil {
		return result
	}

	result = append(result, inorderTraversal(t.Right)...)
	return
}
