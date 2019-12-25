/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件，要么当前某一条路径走完没有找到节点
        // 要么找到p或q中一个节点返回
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;

        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);
        if (left != null && right != null) {
            return root; // p,q在它的左右子树中，它返回到递归的上一层中一定是其父节点左节点或右节点，会原路返回
        }else if (left != null) {
            return left; // 左子节点有，而右子节点没有，说明另一个节点是它的子树，返回它即可
        }else if (right != null) {
            return right; // 右子节点有，而左子节点没有，说明另一个节点是它的子树，返回即可
        }else {
            return null;
        }
    }
}