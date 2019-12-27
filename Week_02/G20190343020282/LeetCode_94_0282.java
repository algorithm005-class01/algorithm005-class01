package com.demo.test.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * TODO
 *给定一个二叉树，返回它的中序 遍历。
 示例:
 输入: [1,null,2,3]
 1
 \
 2
 /
 3

 输出: [1,3,2]

 * @author houyujia
 * @since 2019/12/22
 */
public class binarytreeinorder94 {
    public static void main(String[] args) {
        TreeNode root =new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.right=new TreeNode(3);
        root.right.left=new TreeNode(6);

        method2(root);
    }

    //定义二叉树
    public static class TreeNode{
        public int val;
        public TreeNode left,right;
        public TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }

    /**
     * 解法一：递归
     * 时间复杂度 O(n)
     * @param root
     * @return
     */
    public static List<Integer> method1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        System.out.println(res.toString());
        return res;
    }

    private static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            //左
            if (root.left != null) {
                helper(root.left, res);
            }
            //中
            res.add(root.val);
            //右
            if (root.right != null) {
                helper(root.right, res);
            }

        }


    }

    /**
     * 解法二：利用栈 实现递归
     * 时间复杂度 O(n)
     * @param root
     * @return
     */
    public static  List<Integer> method2(TreeNode root) {
        List <Integer> res = new ArrayList<>();
        Stack <TreeNode> stack = new Stack<>();
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            res.add(root.val);
            root=root.right;
        }
        System.out.println(res.toString());
        return res;
    }


}