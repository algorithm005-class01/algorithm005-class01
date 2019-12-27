import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author huangxiong
 * @Date 2019/12/17
 * @Description 中序 遍历
 **/
public class LeetCode_94_0110 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //1.暴力法，递归
        inorderTraversal(root, list);
        // end
        //2.栈
        Stack< TreeNode > stack = new Stack < > ();
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 1.暴力法，递归
     *
     * @param root
     * @param res
     */
    public void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                inorderTraversal(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                inorderTraversal(root.right, res);
            }
        }
    }
}
