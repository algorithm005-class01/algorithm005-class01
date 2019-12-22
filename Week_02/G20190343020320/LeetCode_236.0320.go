package g20190343020320

// 236.二叉树最近公共祖先
// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
func LowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	if ok, a := loopLowest(root, p, q); ok {
		return a
	}
	return nil
}

func loopLowest(root, p, q *TreeNode) (bool, *TreeNode) {
	if root == nil {
		return false, nil
	}

	lx, l := loopLowest(root.Left, p, q)
	rx, r := loopLowest(root.Right, p, q)

	if l != nil {
		return true, l
	}
	if r != nil {
		return true, r
	}
	if (lx && rx) || ((lx || rx) && (root == p || root == q)) {
		return true, root
	}

	if lx || rx || root == p || root == q {
		return true, nil
	}
	return false, nil
}

// 方法2
// 合并了 bool 与 节点
func LowestCommonAncestor2(root, p, q *TreeNode) *TreeNode {
	if root == nil || root == p || root == q {
		return root
	}

	l := LowestCommonAncestor2(root.Left, p, q)
	r := LowestCommonAncestor2(root.Right, p, q)

	if l != nil && r != nil {
		return root
	}

	if l == nil {
		return r
	}

	return l
}
