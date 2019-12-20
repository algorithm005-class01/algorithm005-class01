package week_02.commit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// 144. 二叉树的前序遍历
// https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
public class Solution_144 {

    // 递归求解
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        recursion(root, result);
        return result;
    }

    private static void recursion(TreeNode root, List<Integer> result) {
        if(root == null){
            return;
        }
        result.add(root.val);
        if(root.left != null){
            recursion(root.left, result);
        }
        if(root.right != null){
            recursion(root.right, result);
        }
    }

    // 使用栈 迭代求解
    public static List<Integer> preorderTraversa2(TreeNode node) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> rights = new Stack<>();
        while(node != null) {
            list.add(node.val);
            if (node.right != null) {
                rights.push(node.right);
            }
            node = node.left;
            if (node == null && !rights.isEmpty()) {
                node = rights.pop();
            }
        }
        return list;
    }

}
