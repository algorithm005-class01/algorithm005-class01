//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

package leetcode.editor.cn;


import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }


//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int preIdx = 0;//前序的下标
        int[] preorder;
        int[] inorder;
        HashMap<Integer, Integer> idxMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;
            for (int i = 0; i < inorder.length; i++) {
                idxMap.put(inorder[i], i);
            }
            return _buildTree(0, inorder.length);
        }

        private TreeNode _buildTree(int left, int right) {

            if (left == right) {
                return null;
            }
            //从前序遍历中取一个来生成树
            int rootVal = preorder[preIdx];
            TreeNode rootNode = new TreeNode(rootVal);
            Integer idx = idxMap.get(rootVal);
            //递归
            preIdx++;

            rootNode.left = _buildTree(left, idx);
            rootNode.right = _buildTree(idx + 1, right);

            return rootNode;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}