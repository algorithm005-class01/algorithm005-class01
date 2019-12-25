package g20190343020320

// 104.二叉树的最大深度
// https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
func MaxDepth(root *TreeNode) int {
	if root == nil {
		return 0
	}
	l := MaxDepth(root.Left)
	r := MaxDepth(root.Right)
	if l < r {
		l = r
	}
	return l + 1
}
