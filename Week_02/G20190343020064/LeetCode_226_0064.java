package G20190343020064;

/**
 * <p>
 * 翻转二叉树
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-26 11:46 上午
 */
public class LeetCode_226_0064 {

    public TreeNode invertTree(TreeNode root) {
        this.invert(root);
        return root;
    }

    public void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
    }

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }

}
