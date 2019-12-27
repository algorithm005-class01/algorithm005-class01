import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // return recursion(root);
        // return iteratorWithStack(root);
        // return iteratorWithStack2(root);
        return iteratorWithMoris(root);
    }

    /**
     * 方法四: 莫里斯遍历 分析同94题
     * @param root
     * @return
     */
    public List<Integer> iteratorWithMoris(TreeNode root){
        LinkedList<Integer> output = new LinkedList<>();

        TreeNode node = root;
        while (node != null) {
          if (node.left == null) {
            output.add(node.val);
            node = node.right;
          }
          else {
            TreeNode predecessor = node.left;
            while ((predecessor.right != null) && (predecessor.right != node)) {
              predecessor = predecessor.right;
            }
    
            if (predecessor.right == null) {
              output.add(node.val);
              predecessor.right = node;
              node = node.left;
            }
            else{
              predecessor.right = null;
              node = node.right;
            }
          }
        }
        return output;
    }

    /**
     * 方法二: 用栈迭代法
     * @param root
     * @return
     */
    public List<Integer> iteratorWithStack(TreeNode root){
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null) {
            list.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right); 
            }
            cur = cur.left;
            if (cur == null && !stack.isEmpty()) {
                cur = stack.pop();
            }
                        
        }
        return list;
    }
    

    /**
     * 方法三: 用栈迭代法2
     * @param root
     * @return
     */
    public List<Integer> iteratorWithStack2(TreeNode root){
        List<Integer> pre = new LinkedList<Integer>();
		if(root==null) return pre;
		Stack<TreeNode> tovisit = new Stack<TreeNode>();
		tovisit.push(root);
		while(!tovisit.empty()) {
			TreeNode visiting = tovisit.pop();
			pre.add(visiting.val);
			if(visiting.right!=null) tovisit.push(visiting.right);
			if(visiting.left!=null) tovisit.push(visiting.left);
		}
		return pre;
    }

    /**
     * 方法一: 递归法
     * @param root
     * @return
     */
    public List<Integer> recursion(TreeNode root){
        List<Integer> list = new ArrayList<>();
        recursionHelper(root, list);
        return list;
    }

    public void recursionHelper(TreeNode root,List<Integer> list){
        if (root != null) {
            list.add(root.val);
            if (root.left != null) {
                recursionHelper(root.left, list);
            }
            if (root.right != null) {
                recursionHelper(root.right, list);
            }
        }
    }
}
// @lc code=end

