/*
 * @lc app=leetcode.cn id=236 lang=csharp
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    public TreeNode result;
    public Solution(){
        result = null;
    }

    private bool findAnswer(TreeNode curr, TreeNode p, TreeNode q){
        if(curr == null) 
            return false;

        int left = findAnswer(curr.left, p, q) ? 1 : 0;
        int right = findAnswer(curr.right, p, q) ? 1 : 0;
        int mid = (curr == p || curr == q) ? 1 : 0;

        if(left + right + mid >= 2){
            this.result = curr;
        }

        return (left + mid + right) > 0;

    }

    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findAnswer(root, p, q);
        return result;
        //时间复杂度：O(N)，N 是二叉树中的节点数，最坏情况下，我们需要访问二叉树的所有节点。
        //空间复杂度：O(N)，这是因为递归堆栈使用的最大空间位 N,斜二叉树的高度可以是 N。

    }
}
// @lc code=end

