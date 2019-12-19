public class LeetCode_98_0190 {
    public boolean isValidBST(TreeNode root) {
        return this.help(root, null, null);
    }

    private boolean help(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;
        if (!help(node.left, min, node.val)) return false;
        if (!help(node.right, node.val, max)) return false;
        return true;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
