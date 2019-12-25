package main.leetcode_solutions.tree;

import main.common.TreeNode;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019/12/20
 */
public class T144_BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}
