package Week2;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 */
public class LeetCode_94_0256 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        getNode(root, list);
        return list;
    }

    private void getNode(TreeNode node, List<Integer> list) {
        if (node != null) {
            if (node.left != null) {
                getNode(node.left, list);
            }
            list.add(node.val);
            if (node.right != null) {
                getNode(node.right, list);
            }
        }
    }

    private List<Integer> getNodeByStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}
