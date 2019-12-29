package com.android.browser.newhome.news.login;


import java.util.HashMap;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_105_0010 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        // start from first preorder element
        int pre_idx = 0;
        int[] preorder;
        int[] inorder;
        HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;

            // build a hashmap value -> its index
            int idx = 0;
            for (Integer val : inorder)
                idx_map.put(val, idx++);
            return getValues(0, inorder.length);
        }

        public TreeNode getValues(int in_left, int in_right) {
            if (in_left == in_right)
                return null;

            int root_val = preorder[pre_idx];
            TreeNode root = new TreeNode(root_val);

            int index = idx_map.get(root_val);

            pre_idx++;
            root.left = getValues(in_left, index);
            root.right = getValues(index + 1, in_right);
            return root;
        }
    }

}
