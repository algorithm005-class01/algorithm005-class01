class Solution {
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    private int[] preorder;
    private int[] inorder;
    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(0, inorder.length);
    }

    private TreeNode helper(int left, int right) {
        if (left == right) return null;
        int value = preorder[preIndex++];
        TreeNode root = new TreeNode(value);
        int index = inorderMap.get(value);
        root.left = helper(left, index);
        root.right = helper(index + 1, right);
        return root;
    }
}