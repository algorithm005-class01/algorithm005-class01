package com.android.browser.newhome.news.login;

import java.util.ArrayList;
import java.util.List;

/**
 *  二叉树的中序遍历 左 根 右
 */
public class LeetCode_94_0010 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();

        getValue(root, list);

        return list;
    }


    public void getValue(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                getValue(root.left, list);
            }
            list.add(root.val);

            if (root.right != null) {
                getValue(root.right, list);
            }
        }


    }

}
