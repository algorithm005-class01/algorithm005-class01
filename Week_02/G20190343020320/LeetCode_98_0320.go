package g20190343020320

// 98.验证二叉搜索树
// https://leetcode-cn.com/problems/validate-binary-search-tree
func IsValidBST(root *TreeNode) bool {
	if root == nil {
		return true
	}
	_, _, x := loopBST(root)
	return x
}

func loopBST(root *TreeNode) (max, min int, x bool) {
	x = true
	if root.Left == nil {
		min = root.Val
	} else {
		lmax, lmin, lx := loopBST(root.Left)
		x = x && lx && root.Val > lmax
		min = lmin
	}
	if root.Right == nil {
		max = root.Val
	} else {
		rmax, rmin, rx := loopBST(root.Right)
		x = x && rx && root.Val < rmin
		max = rmax
	}

	return
}
