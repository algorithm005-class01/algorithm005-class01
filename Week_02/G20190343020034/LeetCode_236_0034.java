package com.example;
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
    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ans;
    }
    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int isFind = 0;
        if (root == p || root == q) {
            isFind = 1;
        }
        int isLeftFind = helper(root.left, p, q) ? 1 : 0;
        int isRightFind = helper(root.right, p, q) ? 1 : 0;
        if (isFind + isLeftFind + isRightFind >= 2) {
            ans = root;
        }
        return (isFind + isLeftFind + isRightFind) >= 1;
    }
}