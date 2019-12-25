import java.util.*;

/**
 * Created by Ju·Felix on 2019/12/22.
 */
public class LeetCode_236_0290 {

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(new TreeNode(null, 6, null), 5, new TreeNode(new TreeNode(null, 7, null), 2, new TreeNode(null, 4, null)));
        TreeNode node1 = new TreeNode(new TreeNode(null, 0, null), 1, new TreeNode(null, 8, null));
        TreeNode root = new TreeNode(node5, 3, node1);
        TreeNode parentNode = lowestCommonAncestor(root, node5, node1);
        System.out.println(parentNode.val);
    }

    /**
     *
     * @param root rootNode
     * @param p node
     * @param q node
     * @return parentNode
     */
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();

        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
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
