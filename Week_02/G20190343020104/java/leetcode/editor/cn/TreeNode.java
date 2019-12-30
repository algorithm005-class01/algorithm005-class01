package leetcode.editor.cn;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    /**
     * 1
     * 2          4
     * 3  5       8 9
     * 6 7
     *
     * @return
     */
    public static TreeNode getTestData() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(8);
        treeNode.right = new TreeNode(9);
        root.left.left = treeNode;
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }


}