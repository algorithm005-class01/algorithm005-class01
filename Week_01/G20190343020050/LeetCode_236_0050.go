package main

/**
 * Definition for TreeNode.
 * type TreeNode struct {
 *     Val int
 *     Left *ListNode
 *     Right *ListNode
 * }
 */

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if root == p || root == q || root == nil{
		return root
	}

	left := lowestCommonAncestor(root.Left, p,q)
	if left == nil {
		return lowestCommonAncestor(root.Right, p,q)
	}
	right := lowestCommonAncestor(root.Right, p,q)
	if right == nil{
		return left
	}

	return root
}