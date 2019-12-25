// 思路：递归
class Solution {
    public List <Integer> inorderTraversal(TreeNode root) {
        List <Integer> res = new ArrayList<>();
        // process logic in current level
		helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List <Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }
}