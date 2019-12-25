package main.leetcode_solutions.tree;

import main.common.TreeNode;

/**
 * @author wenzhuang
 * @date 2019/12/20 11:56 PM
 */
public class T236_LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }
}
