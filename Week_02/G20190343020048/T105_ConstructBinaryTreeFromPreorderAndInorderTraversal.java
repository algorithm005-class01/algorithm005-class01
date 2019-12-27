package main.leetcode_solutions.tree;

import main.common.TreeNode;

/**
 * @author wenzhuang
 * @date 2019/12/21
 */
public class T105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);

    }

    private TreeNode buildTree(int[] preorder, int pl, int pr, int[] inorder, int il, int ir){
        if (pl > pr){
            return null;
        }
        int rootVal = preorder[pl];
        int rootIndex = il;
        for (int i = il; i <= ir; i++){
            if (inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, pl + 1, pl + rootIndex - il, inorder, il, rootIndex - 1);
        root.right = buildTree(preorder, pl + rootIndex - il + 1, pr, inorder, rootIndex + 1, ir);
        return root;
    }
}
