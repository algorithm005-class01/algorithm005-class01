package com.android.browser.newhome.news.login;


/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode_236_0010 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        private TreeNode ans;

        public Solution() {
            // Variable to store LCA node.
            this.ans = null;
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Traverse the tree
            this.recurseTree(root, p, q);
            return this.ans;
        }

        private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

            if (currentNode == null) {
                return false;
            }

            int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

            int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

            int mid = (currentNode == p || currentNode == q) ? 1 : 0;


            if (mid + left + right >= 2) {
                this.ans = currentNode;
            }

            return (mid + left + right > 0);
        }
    }

}
