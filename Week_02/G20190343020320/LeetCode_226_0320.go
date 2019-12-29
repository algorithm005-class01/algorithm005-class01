package g20190343020320

// 226.反转二叉树
// https://leetcode-cn.com/problems/invert-binary-tree/
func InvertTree(root *TreeNode) *TreeNode {
	if root == nil {
		return root
	}

	root.Left, root.Right = root.Right, root.Left
	InvertTree(root.Left)
	InvertTree(root.Right)
	return root
}
