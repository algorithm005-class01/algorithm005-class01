//给定一个二叉树，返回它的中序 遍历。
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
//输出: [1,3,2]
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树 哈希表



//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraverByLoop(root);
    }

    private void inorderTranvalByRecursion (TreeNode root, List<Integer> list) {
        if (root!=null) {
            inorderTranvalByRecursion(root.left, list);
            list.add(root.val);
            inorderTranvalByRecursion(root.right, list);
        }
    }

    private List<Integer> inorderTraverByLoop (TreeNode node) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (node!=null || !stack.isEmpty()) {
            if (node!=null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
