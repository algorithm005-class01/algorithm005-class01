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
    public List<Integer> inorderTraversal(TreeNode root) {
        /**
         * 由于树的结构非常适合使用递归，并且现在计算机对递归存在优化，所以需要多多练习
         * 执行用时 0 ms
         * 内存消耗 34.7 MB
         * 中序遍历 左 根 右
         */
        List<Integer> res = new ArrayList<>();
        getNode(root, res);
        return res;
    }

    private void getNode (TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        getNode(root.left, res);
        res.add(root.val);
        getNode(root.right, res);
    }
}