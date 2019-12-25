package sort.day1;
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

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路：
 * 递归法：
 * 递归终止条件：当某个节点的左节点和右节点都为空时，则说明该节点为叶子节点，从而把该节点的值加到List中。
 * 限制条件：因为是中序遍历，所以先递归遍历当前节点的左子树，再把当前节点加入到List中，再遍历当前节点的右子树。
 *
 * 暴力求解法：
 *
 *
 *
 */

public class BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node7;
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);
        node7.left = node6;
        node7.right = node9;
        List<Integer> result = inorderTraversal(root);
        result.forEach(item -> System.out.println(item));

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        inorderHelp(root,result);
        return result;
    }

    private static void inorderHelp(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorderHelp(root.left,result);
        }
        result.add(root.val);
        if (root.right != null) {
            inorderHelp(root.right,result);
        }
    }


}
