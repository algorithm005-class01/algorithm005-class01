import java.util.ArrayList;
import java.util.List;

public class LeetCode_515_0190 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.helper(root, list, 1);
        return list;
    }

    private void helper(TreeNode node, List<Integer> list, int depth) {
        if (node == null) return;
        if (list.size() < depth) {
            list.add(node.val);
        } else {
            if (list.get(depth - 1) < node.val)
                list.set(depth - 1, node.val);
        }
        this.helper(node.left, list, depth + 1);
        this.helper(node.right, list, depth + 1);
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
