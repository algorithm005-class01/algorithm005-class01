package g20190343020320

// 111.二叉树的最小深度
// https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
func MinDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	if root.Left == nil && root.Right == nil {
		return 1
	}

	l := MinDepth(root.Left)
	r := MinDepth(root.Right)
	if l > r && r > 0 || l == 0 {
		return r + 1
	}
	return l + 1
}
