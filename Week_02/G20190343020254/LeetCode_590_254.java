/**
 * 题目：N叉树的后序遍历
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * 详情：
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 */

/**
 * 思路迭代：
 * 覃超老师的经典四部曲。but我的理解是：根据清空不同，第2，3步有时候需要调换
 */

class Solution {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        helper(root);
        return res;
    }
    public void helper(Node root) {
        // 退出条件
        if(root == null) {
            return;
        }

        // 下探到下一层
        int s = root.children.size();
        for(int i = 0; i < s; i++) {
            helper(root.children.get(i));
        }

        // 当前层的处理
        res.add(root.val);
    }
}

/*
 其他解法：

 解法1：
 class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res  =  new ArrayList<Integer>();
        if(root == null) return res;
        for(Node cur:root.children){
            res.addAll(postorder(cur));
        }
        res.add(root.val);
        return res;
    }

 解法2：
    class Solution {
    LinkedList<Integer> list = new LinkedList<>();
    LinkedList<Node> stack = new LinkedList<>();

    public List<Integer> postorder(Node root) {
        if(root==null) {
            return list;
        }
        stack.add(root);
        while(!stack.isEmpty()) {
            Node node = stack.pollLast();
            list.addFirst(node.val);
            for(Node n:node.children) {
                if(n!=null) {
                    stack.add(n);
                }
            }
        }
        return list;
    }
}
}


 */

