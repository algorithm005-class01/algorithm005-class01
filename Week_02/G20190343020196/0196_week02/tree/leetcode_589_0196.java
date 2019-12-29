package tree;

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
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
class Solution2 {

    public static class Node {
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

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();

        pushRoot(root, res);
        return res;
        
    }

    private void pushRoot(Node root, List<Integer> res) {
        if (root != null) {
            
            //中
            res.add(root.val);

            if (root.children != null) {
                for (int i = 0; i < root.children.size(); i++) {
                    pushRoot(root.children.get(i), res);
                }
            }

           
        }
    }

     public static void main(String[] args) {

        Solution2 sol = new Solution2();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        List<Node> nodeArr1 = new ArrayList<Node>();
        nodeArr1.add(node3);
        nodeArr1.add(node2);
        nodeArr1.add(node4);

        List<Node> nodeArr2 = new ArrayList<Node>();
        nodeArr2.add(node5);
        nodeArr2.add(node6);

        node1.children = nodeArr1;
        node3.children = nodeArr2;
        
        System.out.println(sol.preorder(node1)); 
    } 
}
// @lc code=end

