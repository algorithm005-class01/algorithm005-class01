public class LeetCode_236_0192 {

    // 236. 二叉树的最近公共祖先 https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree

    /*
    解法
    参考 https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-ale/
    1. 若存在最近公共祖先只有3种情况
      1.1. p、q全部在左侧，答案是p、q中第一个被检索到的
      1.2. p、q全部在右侧，答案是p、q中第一个被检索到的
      1.3. p、q在左右两侧
    2. 利用递归遍历二叉树
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // p、q在左右两侧
        if (left != null && right != null) {
            return root;
        }

        // 利用排除法筛选结果
        return left == null ? right : left;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
