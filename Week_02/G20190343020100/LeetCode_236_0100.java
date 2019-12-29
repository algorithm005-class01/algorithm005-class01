package com.algorithm.week02;

import javax.swing.tree.TreeNode;

public class LeetCode_236 {


  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //递归返回条件
    if (root == p || root == q || root == null) return root;

    //doing
    TreeNode l = root.left;
    TreeNode r = root.right;

    //递归
    TreeNode lc = lowestCommonAncestor(l, p, q);
    TreeNode rc = lowestCommonAncestor(r, p, q);

    if (lc != null && rc != null ) return root;
    //这题特殊在此处需要进行回溯
    return lc == null ?  rc:lc;
  }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
//runtime:9 ms
//memory:35.4 MB
