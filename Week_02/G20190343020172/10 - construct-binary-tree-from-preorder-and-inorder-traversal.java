class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
			return null;
		}
		return help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private TreeNode help(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
		//递归终止条件
		if (pStart > pEnd || iStart > iEnd) {
			return null;
		}
		//重建根节点
		TreeNode treeNode = new TreeNode(preorder[pStart]);
		int index = 0;  //index找到根节点在中序遍历的位置
		while (inorder[iStart + index] != preorder[pStart]) {
			index++;
		}
		//重建左子树
		treeNode.left = help(preorder, pStart + 1, pStart + index, inorder, iStart, iStart + index - 1);
		//重建右子树
		treeNode.right = help(preorder, pStart + index + 1, pEnd, inorder, iStart + index + 1, iEnd);
		return treeNode;

	}
}