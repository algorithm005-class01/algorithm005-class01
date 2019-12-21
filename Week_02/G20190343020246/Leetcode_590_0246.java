/**
 * 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
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

/**
 * 算法思路：1.采用递归
 * 2. 后序遍历的特点：先左右节点 再根节点
 */
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        helper(root, list);

        return list;
    }

    public void helper(Node root, List list) {
        if(root != null) {
            if(root.children != null) { // 先遍历左右子树
                for(Node node : root.children) {
                    helper(node, list);
                }
            }
            list.add(root.val); // 然后在遍历根
        }
    }
}