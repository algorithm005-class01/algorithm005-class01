package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	buildTree([]int{3, 9, 20, 15, 7}, []int{9, 3, 15, 20, 7})
}

/*
 * @lc app=leetcode.cn id=105 lang=golang
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func buildTree(preorder []int, inorder []int) *TreeNode {
	if nil == preorder || nil == inorder {
		return nil
	}

	if len(preorder) == 0 || len(inorder) == 0 {
		return nil
	}

	m := make(map[int]int, len(inorder))
	for i, v := range inorder {
		m[v] = i
	}

	var root TreeNode
	idx := 0
	addNode(preorder, inorder, 0, len(preorder)-1, &idx, &root, m)
	return &root
}

func addNode(pre, in []int, start, end int, idx *int, root *TreeNode, m map[int]int) {
	if *idx >= len(pre) {
		return
	}
	root.Val = pre[*idx]
	pos := m[root.Val]

	if pos-start > 0 {
		root.Left = &TreeNode{}
		*idx += 1
		addNode(pre, in, start, pos-1, idx, root.Left, m)
	}

	if end-pos > 0 {
		root.Right = &TreeNode{}
		*idx += 1
		addNode(pre, in, pos+1, end, idx, root.Right, m)
	}
}

// @lc code=end

