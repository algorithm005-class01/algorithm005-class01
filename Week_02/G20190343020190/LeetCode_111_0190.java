public class LeetCode_111_0190 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.right == null && root.left == null) return 1;
        int minDepth = Integer.MAX_VALUE;
        if (root.left != null)
            minDepth = Math.min(this.minDepth(root.left), minDepth);
        if (root.right != null)
            minDepth = Math.min(this.minDepth(root.right), minDepth);
        return minDepth + 1;
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
