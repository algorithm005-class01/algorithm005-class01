/*
 * @lc app=leetcode.cn id=105 lang=csharp
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    private int[] preorder;
    private int[] inorder;
    private Dictionary<int, int> inorderDic = new Dictionary<int, int>();
    private int preIndex = 0;
    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.Length!=inorder.Length){
            return null;
        }

        this.preorder = preorder;
        this.inorder = inorder;

        for (int i = 0; i < inorder.Length; i++)
        {
            inorderDic.Add(inorder[i], i);
        }
        
        return BuildTree(0, preorder.Length - 1);
    }

    private TreeNode BuildTree(int start, int end){
        if(start > end){
            return null;
        }

        int pivot = preorder[preIndex];
        TreeNode node = new TreeNode(pivot);

        int index = inorderDic[pivot];
        preIndex++;
        node.left = BuildTree(start, index-1);
        node.right = BuildTree(index+1, end);
        return node;
    }
}
// @lc code=end

