//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树



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
    /**
     * 方法一：递归（借助helper方法）前序遍历（根左右）
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    public void helper(TreeNode node,List<Integer> res){
        if(node == null){return;}
        res.add(node.val);
        if(node.left != null){
            helper(node.left,res);
        }
        if(node.right != null){
            helper(node.right,res);
        }
    }

    /**
     * 方法二：利用栈，根左右，对于每个出栈元素，加入res，先压右孩子，再压左孩子，这样出来顺序就是根左右
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if(curr.right!= null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
