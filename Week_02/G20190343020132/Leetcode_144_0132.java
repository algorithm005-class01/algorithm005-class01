package org.azai.train.Week02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_144_0132 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    //解法1：递归遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root,result);
        return result;
    }
    public void dfs (TreeNode root,List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        dfs(root.left,result);
        dfs(root.right,result);
    }
    //解法2：用栈模拟实现递归
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode head = root;
        while (!stack.isEmpty()) {
            head = stack.pop();
            result.add(head.val);
            if (head.right!=null) {
                stack.push(head.right);
            }
            if (head.left!=null) {
                stack.push(head.left);
            }
        }
        return result;
    }
}
