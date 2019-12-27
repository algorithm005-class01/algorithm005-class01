package com.android.browser.newhome.news.login;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历 根 左 右
 */
public class LeetCode_144_0010 {

    //Definition for a binary tree node.
    class Solution {

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList();

            getValue(root, list);

            return list;
        }

        public void getValue(TreeNode root, List<Integer> list) {
            if (root != null) {
                list.add(root.val);
                if (root.left != null) {
                    getValue(root.left, list);
                }
                if (root.right != null) {
                    getValue(root.right, list);
                }
            }

        }
    }
}
