import java.util.HashMap;

public class LeetCode_105_0190 {
    int pre_idx = 0;
    int[] preOrder;
    HashMap<Integer, Integer> idx_map = new HashMap<>();

    public TreeNode helper(int left, int right) {
        if (left == right) return null;
        int root_val = preOrder[pre_idx];
        TreeNode root = new TreeNode(root_val);
        int index = idx_map.get(root_val);
        pre_idx++;
        root.left = helper(left, index);
        root.right = helper(index + 1, right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        int idx = 0;
        for (int val : inorder)
            idx_map.put(val, idx++);
        return helper(0, inorder.length);
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
