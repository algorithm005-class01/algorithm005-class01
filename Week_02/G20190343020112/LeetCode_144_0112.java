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
        return preorderTraversal(root, new ArrayList<Integer>());
    }

    private List<Integer> preorderTraversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            preorderTraversal(root.left, res);
            preorderTraversal(root.right, res);
        }
        return res;
    }
}