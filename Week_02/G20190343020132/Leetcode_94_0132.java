package org.azai.train.Week02;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode_94_0132 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root,result);
        return result;
    }
    public void dfs(TreeNode root,List<Integer> result){
        if (root==null) {
            return;
        }
        dfs(root.left,result);
        result.add(root.val);
        dfs(root.right,result);
    }
    //解法2：迭代遍历  用栈手动实现递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode head = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            }else{
                head = stack.pop();
                result.add(head.val);
                head = head.right;
            }
        }
        return result;
    }
}
