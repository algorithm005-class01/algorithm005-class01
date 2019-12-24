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
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode helper(int [] preorder, int preLow, int preHigh, int[] inorder, int inLow, int inHigh){
        if(preLow>preHigh || inLow>inHigh) return null;
        TreeNode root = new TreeNode(preorder[preLow]);

        int inorderRoot = inLow;
        for(int i=inLow;i<=inHigh;i++){
            if(inorder[i]==root.val){ inorderRoot=i; break; }
        }

        int leftTreeLen = inorderRoot-inLow;
        root.left = helper(preorder, preLow+1, preLow+leftTreeLen, inorder, inLow, inorderRoot-1);
        root.right = helper(preorder, preLow+leftTreeLen+1, preHigh, inorder, inorderRoot+1, preHigh);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
