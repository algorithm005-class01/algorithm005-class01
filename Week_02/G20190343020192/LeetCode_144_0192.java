import java.util.ArrayList;
import java.util.List;

public class LeetCode_144_0192 {

    // 144. 二叉树的前序遍历 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    public void traversal(TreeNode root, List<Integer> list){
        if (root == null) {
            return;
        }
        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, list);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
