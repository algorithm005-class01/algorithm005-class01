package main.leetcode_solutions.tree;

import main.common.TreeNode;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019/12/20
 */
public class T94_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode root, List<Integer> res){
        if (root == null){
            return;
        }
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }
}
