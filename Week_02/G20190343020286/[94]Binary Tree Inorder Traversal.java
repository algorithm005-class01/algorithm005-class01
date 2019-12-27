//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表



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
     * 方法一：递归，中序遍历，左根右
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }
    public void helper(TreeNode node,List<Integer> res){
        if(node == null){return;}
        if(node.left != null) {
            helper(node.left,res);
        }
        res.add(node.val);
        if(node.right != null) {
            helper(node.right,res);
        }
    }

    /**
     * 方法二：利用栈，对于每个节点，一直将其最左节点全部压入栈，
     * 将栈顶元素加入res，然后移到当前节点的右孩子
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){return res;}
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.push(curr);
        while (curr != null || !stack.isEmprty()){
            /* 错误，例预期[1,3,2]，结果[1,3]
            while (curr.left != null){
                stack.push(curr.left);
                curr = curr.left;
            }
            */
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
