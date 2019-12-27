import java.util.*;

/**
 * Created by Ju·Felix on 2019/12/22.
 */
public class LeetCode_94_0290 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(null, 1, new TreeNode(new TreeNode(null, 3, null), 2, null));
        List<Integer> result = inorderTraversal(root);
        System.out.println(result.toString());
    }


    /**
     * @param root [1, null, 2, 3]
     * @return [1, 3, 2]
     */
    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }



    static class TreeNode {
        TreeNode left;
        Integer val;
        TreeNode right;

        TreeNode(TreeNode left, Integer val, TreeNode right) {
            this.left = left;
            this.val = val;
            this.right = right;
        }
    }
}
