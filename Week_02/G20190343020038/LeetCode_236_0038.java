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
    //https://www.youtube.com/watch?v=WqNULaUhPCc
    //分治法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //Edge/Condition
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        
        //Divide
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        //Conquer
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}