package week_02.commit;

import java.util.*;

// 590. N叉树的后序遍历
// https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
public class Solution_590 {

    // 二叉树的后序遍历
    public static List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return result;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return result;
    }

    // 这个是借助二叉树后序遍历
    public static List<Integer> postorder0(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) return result;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            result.addFirst(cur.val);
            if (cur.children != null) {
                for (Node node : cur.children) {
                    stack.push(node);
                }
            }
        }
        return result;
    }

    // Iterative
    public static List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            if (root.children != null) {
                for (Node node : root.children)
                    stack.add(node);
            }
        }
        Collections.reverse(result);
        return result;
    }

    // Iterative 借助LinkedList 与上面解法做对比
    public static List<Integer> postorder4(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            result.addFirst(root.val);
            if (root.children != null) {
                for (Node node : root.children)
                    stack.add(node);
            }
        }
        return result;
    }

    public static List<Integer> postorder3(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        recursion(root, result);
        return result;
    }

    private static void recursion(Node root, List<Integer> result) {
        if (root == null)
            return;
        if (root.children != null) {
            for (Node node : root.children)
                recursion(node, result);
        }
        result.add(root.val);
    }


}

;
