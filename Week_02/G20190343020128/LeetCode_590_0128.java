import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        return recursion(root);
        // return iteratorWithStack(root);
        
    }


    public List<Integer> iteratorWithStack(Node root){
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        while (cur != null) {
            boolean noKid = true; 
            /**
             * 如果有子结点的话, 先将根节点压入栈,然后将子节点从后向前压入栈,为的是可以从前往后
             * 遍历,但第一个子节点不入栈
             */
            if (cur.children != null && root.children.size()>0) {
                //由于是后序,所以先把根节点压入栈中
                stack.push(cur);
                for (int i = root.children.size()-1; i > 0; i--) {
                    stack.push(root.children.get(i));
                }
                //有子节点,则将子节点作为下一个子树的根节点传入
                cur = root.children.get(0);
                noKid = false;
            }
            if (noKid) {
                list.add(cur.val);
                cur = null;
            }
            if (cur == null && !stack.isEmpty()) {                
                //遍历完值上一个节点也就没有用了,继续pop出新节点
                cur = stack.pop();
            }
        }
        return list;
    }

    /**
     * 方法一: 递归法
     * @param root
     * @return
     */
    public List<Integer> recursion(Node root){
        List<Integer> list = new ArrayList<>();
        recursionHelper(root,list);
        return list;
    }

    public void recursionHelper(Node root,List<Integer> list){
        if (root != null) {
            if (root.children != null && root.children.size()>0) {
                for (int i = 0; i < root.children.size(); i++) {
                    recursionHelper(root.children.get(i),list);
                }
            }
            list.add(root.val);
        }

    }
}
// @lc code=end

