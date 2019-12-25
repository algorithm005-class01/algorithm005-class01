package G20190343020220.leetcode_236_0220;

/**
 * 236. 二叉树的最近公共祖先
 *
 * @author Darcy
 * @date 2019-12-20 14:11
 */
public class Sulotion {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = this.lowestCommonAncestor(root.left, p, q);
        TreeNode right = this.lowestCommonAncestor(root.right, p, q);

        return left == null ? right : right == null ? left : root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
