package week_02.commit;

// 105. 从前序与中序遍历序列构造二叉树
// https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class Solution_105 {

    // 递归求解
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursion(0, 0, inorder.length - 1, preorder, inorder);
    }

    private static TreeNode recursion(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = recursion(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = recursion(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
