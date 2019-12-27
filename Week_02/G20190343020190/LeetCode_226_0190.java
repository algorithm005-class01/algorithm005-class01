public class LeetCode_226_0190 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode right = this.invertTree(root.right);
        TreeNode left = this.invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
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
