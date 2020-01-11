import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_102_0190 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<>();
        if (root == null) return wrapList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                subList.add(node.val);
            }
            wrapList.add(subList);
        }
        return wrapList;
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
