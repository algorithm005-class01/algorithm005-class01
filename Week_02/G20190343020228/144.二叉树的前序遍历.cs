/*
 * @lc app=leetcode.cn id=144 lang=csharp
 *
 * [144] 二叉树的前序遍历
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
        public IList<int> PreorderTraversal(TreeNode root) {
        List<int> result = new List<int>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode node, List<int> result){
        if(node!=null){
            result.Add(node.val);
            if(node.left!=null){
                helper(node.left,result);
            }
            if(node.right!=null){
                helper(node.right,result);
            }
        }
    }
}
// @lc code=end

