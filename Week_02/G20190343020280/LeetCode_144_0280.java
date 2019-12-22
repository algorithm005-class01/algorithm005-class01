//给定一个二叉树，返回它的 前序 遍历。
//
// 示例:
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,2,3]
//
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树



//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTravelByLoop(root);
    }

    private void preorderTraversalByRecursion (TreeNode root, List<Integer> list) {
        if (root!=null) {
            list.add(root.val);
            preorderTraversalByRecursion(root.left, list);
            preorderTraversalByRecursion(root.right, list);
        }
    }

    private List<Integer> preorderTravelByLoop(TreeNode node) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (node!=null || !stack.isEmpty()) {
            if (node!=null) {
                list.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
