import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (69.27%)
 * Likes:    345
 * Dislikes: 0
 * Total Accepted:    86.3K
 * Total Submissions: 124.6K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * 输出: [1,3,2]
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
class Solution {
    //递归写法
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        inorderTraversal(root, res);
        return res;
    }
    
    private void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            inorderTraversal(node.left, list);
            list.add(node.val);
            inorderTraversal(node.right, list);
        }
    }
}
*/

class Solution {
    //迭代写法
    //https://www.youtube.com/watch?v=xGtb5F1A7kE
    public List<Integer> inorderTraversal(TreeNode root) { 
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;            
        }
        return res;
    }
}
// @lc code=end

