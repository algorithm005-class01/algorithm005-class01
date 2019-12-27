package g20190343020320

// 94.二叉树的中序遍历
func inorderTraversal(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}
	reArr := append(inorderTraversal(root.Left), root.Val)
	return append(reArr, inorderTraversal(root.Right)...)
}

// 自己维护一个栈
func inorderTraversal2(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}
	stack, output, p := []*TreeNode{}, []int{}, root
	for p != nil || len(stack) > 0 {
		for p != nil {
			stack, p = append(stack, p), p.Left
		}

		p, stack = stack[len(stack)-1], stack[:len(stack)-1]
		output, p = append(output, p.Val), p.Right
	}

	return output
}
