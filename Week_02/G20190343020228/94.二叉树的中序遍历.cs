/*
 * @lc app=leetcode.cn id=94 lang=csharp
 *
 * [94] 二叉树的中序遍历
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
    public IList<int> InorderTraversalWithStack(TreeNode root){
        List<int> result = new List<int>();
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode curr = root;
            while (curr != null || stack.Count != 0)
            {
                while (curr != null)
                {
                    stack.Push(curr);
                    curr = curr.left;
                }

                curr = stack.Pop();
                result.Add(curr.val);
                curr = curr.right;
            }

            return result;
    }


    public IList<int> InorderTraversalWithRecursive(TreeNode root) {
        List<int> result = new List<int>();
        Traversal(root, result);
        return result;
    }

    private void Traversal(TreeNode node, List<int> result){
        if(node!=null){
            if(node.left!=null){
                Traversal(node.left, result);
            }
            result.Add(node.val);
            if(node.right!=null){
                Traversal(node.right, result);
            }
        }
    }
}
// @lc code=end

