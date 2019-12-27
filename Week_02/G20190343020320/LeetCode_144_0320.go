package g20190343020320

// 144.二叉树的前序遍历
// https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
func PreorderTraversal(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}
	reVal := append([]int{root.Val}, PreorderTraversal(root.Left)...)
	return append(reVal, PreorderTraversal(root.Right)...)
}

// 自己维护一个栈
func PreorderTraversal2(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}
	stack, putout := []*TreeNode{root}, []int{}
	for len(stack) > 0 {
		p := stack[len(stack)-1]
		putout, stack = append(putout, p.Val), stack[:len(stack)-1]
		if p.Right != nil {
			stack = append(stack, p.Right)
		}
		if p.Left != nil {
			stack = append(stack, p.Left)
		}
	}
	return putout
}
