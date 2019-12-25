import java.util.LinkedList;
import java.util.List;

/**
 * @Author huangxiong
 * @Date 2019/12/17
 * @Description 前序 遍历
 **/
public class LeetCode_144_0110 {
    /**
     * 迭代 时间复杂度为 O(N)
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        if (root == null) {
            return linkedList;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            linkedList.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return linkedList;
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
