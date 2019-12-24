import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/* *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//解法1： 递归 recursive
class Solution1 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        final List<Integer> res = new ArrayList<>();
        pushRoot(root, res);
        return res;
    }

    public void pushRoot(TreeNode root, List<Integer> res) {
        if (root != null) {
            //左
            if (root.left != null) {
                pushRoot(root.left, res);
            }
            //根
            res.add(root.val);
            //右
            if (root.right != null) {
                pushRoot(root.right, res);
            }
        }
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(sol.inorderTraversal(node1));

    }

}


//解法2 , iterative
class Solution2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //栈辅助
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        //空栈
        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                //入栈
                stack.push(curr);
                //继续 左
                curr = curr.left;
            }

            //遇到curr空, 出栈
            curr = stack.pop();
            res.add(curr.val);
            //看右
            curr = curr.right;
        }
        return res;
    }
}

//莫里斯遍历 有空再看吧
//官方的题解是破坏树的结构，下方留言有更优解
//知识点线索二叉树和莫里斯方法解析

// @lc code=end