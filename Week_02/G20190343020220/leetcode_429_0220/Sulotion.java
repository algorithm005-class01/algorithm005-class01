package G20190343020220.leetcode_429_0220;

/*
* 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

例如，给定一个 3叉树 :

 



 

返回其层序遍历:

[
     [1],
     [3,2,4],
     [5,6]
]
 

说明:

树的深度不会超过 1000。
树的节点总数不会超过 5000。
* */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * n叉树层级遍历
 *
 * @author Darcy
 * @date 2019-12-18 13:45
 */
public class Sulotion {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> nodes = new ArrayDeque<>();
        nodes.addFirst(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> ls = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = nodes.removeFirst();
                ls.add(node.val);
                if (node.children != null) {
                    for (Node c : node.children) {
                        nodes.addFirst(c);
                    }
                }
            }
            res.add(ls);
        }
        return res;

    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
