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

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class InorderTraversal {

    class FlagNode {
        TreeNode node;
        String flag;

        public FlagNode(TreeNode node,String flag){
            this.node = node;
            this.flag = flag;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();

        List<Integer> res = new ArrayList<>();
        Stack<FlagNode> stack = new Stack<>();
        stack.push(new FlagNode(root,"0"));

        while(!stack.empty()){
            FlagNode cn = stack.pop();

            if(cn.flag.equals("0")){
                if(cn.node.right != null) stack.push(new FlagNode(cn.node.right,"0"));
                stack.push(new FlagNode(cn.node,"1"));
                if(cn.node.left != null)stack.push(new FlagNode(cn.node.left,"0"));
            }else{
                res.add(cn.node.val);
            }
        }

        return res;
    }

//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode curr = root;
//        while (curr != null || !stack.isEmpty()){
//            while(curr != null){
//                stack.push(curr);
//                curr = curr.left;
//            }
//            curr = stack.pop();
//            list.add(curr.val);
//            curr = curr.right;
//        }
//        return list;
//    }
//    //1递归
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        center(root,list);
//        return list;
//    }
//
//    public void center(TreeNode root, List<Integer> list) {
//        if(root != null){
//            if(root.left != null){
//                center(root.left,list);
//            }
//            list.add(root.val);
//            if(root.right != null){
//                center(root.right,list);
//            }
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
