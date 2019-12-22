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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
         * 跟据题解的递归方法理解了一下
         * 前序遍历为 根 左 右 ，中序遍历为 左 根 右，则前序遍历的第一个元素肯定为根元素，
         * 而找到根元素后，再找到中序遍历中根元素的位置，就可以确定左右子树分别有那些元素以及左右子树的元素个数，
         * 根据这些，又可以在前序遍历中分别获取左子树和右子树中的根，再将左右子树以此类推分别迭代下去，
         * 这样就有重复性了，可以通过递归找到完整的结构
         *
         * 此方法由于循环遍历了多次，效率不是很高，还有使用哈希表缓存来提速的方法，总体思路逻辑差不多
         */

        return getTreeNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }


    private TreeNode getTreeNode (int[] preorder, int p_start, int p_end, int[] inorder,
                                  int i_start, int i_end) {
        //终止条件
        if (p_start == p_end) {
            return null;
        }
        //中间执行逻辑
        //设置根节点
        int root_val = preorder[p_start];
        TreeNode res = new TreeNode(root_val);
        //从中序遍历数据获取左右子树的长度
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++ ) {
            if (inorder[i] == root_val) {
                i_root_index = i;
                break;
            }
        }
        //左子树的长度
        int left_length = i_root_index - i_start;
        //前往下一层
        res.left = getTreeNode(preorder, p_start + 1, p_start + left_length + 1, inorder, i_start, i_root_index);
        res.right = getTreeNode(preorder, p_start + left_length + 1, p_end, inorder, i_root_index + 1, i_end);
        return res;
    }
}