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



//leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

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
    private int rooIndex = 0;
    private Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i<inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length);
    }

    private TreeNode buildTree (int[] preorder, int[] inorder, int left, int right) {
        if (left==right) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[rooIndex]);
        int inorderIndex = inorderMap.get(preorder[rooIndex]);
        rooIndex++;
        node.left = buildTree(preorder, inorder, left, inorderIndex);
        node.right = buildTree(preorder, inorder, inorderIndex+1, right);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
