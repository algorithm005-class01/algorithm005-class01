/**
 * 题目：N叉树的前序遍历
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 * 详情：
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 */

class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) return list;
        load(root, list);
        return list;
    }

    private void load(Node root, List<Integer> list) {
        if (root == null) return;
        for (Node node : root.children) {
            load(node, list);
        }
        list.add(root.val);
    }
}