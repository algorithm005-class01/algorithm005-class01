//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索



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
    /**验证二叉搜索树
     * 方法一：递归
     * 对于每一个节点，传入其上下边界，再递归判断其左右孩子
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    public boolean helper(TreeNode node,Integer lower,Integer upper){
        if(node == null){return true;}
        if(lower != null && node.val <= lower){//注意，等于也不是二叉搜索树
            return false;
        }
        if(upper != null && node.val >= upper){
            return false;
        }
        if(!helper(node.left,lower,node.val)){
            return false;
        }
        if(!helper(node.right,node.val,upper)){
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
