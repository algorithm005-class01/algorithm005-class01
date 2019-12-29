package week_02.commit;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 94. 二叉树的中序遍历
// https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
public class Solution_94 {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

    // 递归
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        recusrion(root, result);
        return result;
    }

    private static void recusrion(TreeNode root, List<Integer> result) {
        if (null == root) {
            return;
        }
        if (root.left != null) {
            recusrion(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            recusrion(root.right, result);
        }
    }
}

