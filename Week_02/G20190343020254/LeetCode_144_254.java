/**
 * 题目：二叉树的前序遍历
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * 详情：
 * 给定一个二叉树，返回它的 前序 遍历。
 */

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(TreeNode node, List<Integer> list){
        if(node != null){
            list.add(node.val);
            if(node.left != null){
                helper(node.left, list);
            }
            if(node.right != null){ 
                helper(node.right, list);
            }
        }
    }
}


