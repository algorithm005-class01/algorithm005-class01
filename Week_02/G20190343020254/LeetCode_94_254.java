package com.app.leetcode.leetcode94;

/**
 * 题目：二叉树的中序遍历
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 详情：
 * 给定一个二叉树，返回它的中序 遍历。
 */


/**
 * 思路：递归
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode t, List<Integer> list) {
        // 如果当前阶段为null就不用玩了
        if (t != null) {
            // 寻找左子节点
            if (t.left != null) {
                helper(t.left, list);
            }
            // 如果当前子结点没有左结点，打印当前结点
            list.add(t.val);
            // 寻找下一个右子节点
            if (t.right != null) {
                helper(t.right, list);
            }
        }
    }
}

/**
 * 解法2:
 * 思路：
 * 基于栈的遍历，先进后出
 * <p>
 * 代码

 class Solution {
     public List<Integer> inorderTraversal(TreeNode root) {
            // 打印的列表
         List<Integer> res = new ArrayList<>();
         Stack<TreeNode> stack = new Stack<>();
         TreeNode cur = root;
         while(cur != null || !stack.isEmpty()) {
            // 找左子节点，依次压栈
             while(cur != null){
                 stack.push(cur);
                 cur = cur.left;
             }
                // 打印最小的左子节点，出栈
             cur = stack.pop();
                // 加入列表
             res.add(cur.val);
                // 找右边的子节点，遍历入栈
             cur = cur.right;
         }
         return res;   
     }
 }
 */

