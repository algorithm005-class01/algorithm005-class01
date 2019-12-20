package G20190343020220.leetcode_105_0220;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 前序遍历 根左右
 * 中序遍历 左根右
 *
 * @author Darcy
 * @date 2019-12-20 14:49
 */
public class Sulotion {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTreeHelper(preorder, inorder, (long) Integer.MAX_VALUE + 1);

    }

    int pre;
    int in;

    /**
     * @param preOrder 前序集合
     * @param inOrder  后续集合
     * @param stop     停止节点
     * @return 构建树
     */
    private TreeNode buildTreeHelper(int[] preOrder, int[] inOrder, long stop) {
        /*边界条件 前序集合遍历完成.*/
        if (pre == preOrder.length) {
            return null;
        }
        /*到了停止节点*/
        if (inOrder[in] == stop) {
            in++;
            return null;
        }
        /*根节点, 不解释了*/
        int root = preOrder[pre++];
        /*构建root*/
        TreeNode treeNode = new TreeNode(root);
        /*root的左子树的stop. 既是在中序集合中找到root, 左根右嘛*/
        treeNode.left = this.buildTreeHelper(preOrder, inOrder, root);
        /*root的右子树的stop. 既是preOrder遍历结束.*/
        treeNode.right = this.buildTreeHelper(preOrder, inOrder, stop);
        return treeNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
