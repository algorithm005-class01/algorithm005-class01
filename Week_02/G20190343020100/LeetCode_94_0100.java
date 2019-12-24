package com.algorithm.week02;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_94 {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    add(root,result);
    return result;
  }

  public void add(TreeNode root , List<Integer> result){
    if (root == null) return;

    if (null != root.left)
      add(root.left,result);

    result.add(root.val);

    if (null != root.right)
      add(root.right,result);
  }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
//runtime:0 ms
//memory:35 MB
