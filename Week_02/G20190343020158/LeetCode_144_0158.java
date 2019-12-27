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
    public List<Integer> preorderTraversal(TreeNode root) {
        /**
         * 递归形式
         * 前序遍历 根 左 右
         */
        List<Integer> res = new ArrayList<>();
        getNode(root, res);
        return res;
    }

    private void getNode (TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        getNode(root.left, res);
        getNode(root.right, res);
    }
}