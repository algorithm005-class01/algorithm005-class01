public class LeetCode_104_0190 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        else return Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
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
