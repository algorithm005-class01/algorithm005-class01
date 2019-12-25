package g20190343020320

// 105.从前序与中序遍历序列构造二叉树
// https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
func BuildTree(preorder, inorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}

	var l, r *TreeNode
	root := preorder[0]

	if len(preorder) > 1 {
		var p int
		for i := 0; i < len(inorder); i++ {
			if inorder[i] == root {
				p = i
				break
			}
		}

		l = BuildTree(preorder[1:p+1], inorder[:p])
		r = BuildTree(preorder[p+1:], inorder[p+1:])
	}

	return &TreeNode{root, l, r}
}
