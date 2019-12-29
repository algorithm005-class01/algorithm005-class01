public class LeetCode_105_0192 {

    // 105. 从前序与中序遍历序列构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

    /*
    解题思路：
    1. 从左到右遍历preorder、inorder
    2. preorder的第一个元素一定是根元素
      2.1. 找到根元素后，可以在inorder中区分左、右子树
      2.2. 当前根的左子树范围：inorder[inorder未查找的最左边（从0开始）, 和根元素相等的索引位置)
      2.3. 当前根的左子树范围：preorder(当前根索引位置（从0开始）, 当前根的索引位置 + inorder已知左子树长度]
           原因：因为preorder、inorder中左、右子树的长度相等（只是观察得出，为什么这么巧，还没想透彻）
    3. 当preorder的指针向右移动到"左子树长度"，说明当前根节点的左子树已经处理完毕
    4. 递归开始查找，如果没有超出左子树范围，preorder指针向右移动一位继续搜索
      4.1. 此时的节点最多只可能有2种身份：A + B
        A. 根节点
        B. 左节点或右节点
      4.2. inorder的起始节点是"最左的节点"，当preorder中的值与他相等时，可以判断无后续数据，结束搜索
      4.3  inorder指针向右移动一位（排除已使用节点），缩小搜索范围
    5. 右节点确定规则：因为上一步确定的是一个左节点，preorder顺序为根左右，所以preorder的下一个节点就是右节点
     */

    private int in = 0;
    private int pre = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MAX_VALUE + 1L);
    }

    private TreeNode build(int[] preorder, int[] inorder, long stop) {
        if (pre == preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
