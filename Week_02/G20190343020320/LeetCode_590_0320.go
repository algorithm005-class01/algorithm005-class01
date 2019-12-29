package g20190343020320

// 590.N叉树多后序遍历
// https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
func Postorder(root *NTreeNode) (reArr []int) {
	if root == nil {
		return []int{}
	}

	for _, child := range root.Children {
		reArr = append(reArr, Postorder(child)...)
	}

	return append(reArr, root.Val)
}

// 维护栈
