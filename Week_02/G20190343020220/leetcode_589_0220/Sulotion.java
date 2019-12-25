package G20190343020220.leetcode_589_0220;


/*
* 给定一个 N 叉树，返回其节点值的前序遍历。

例如，给定一个 3叉树 :







返回其前序遍历: [1,3,5,6,2,4]。*/

import java.util.ArrayList;
import java.util.List;

/**
 * @author Darcy
 * @date 2019-12-18 10:49
 */
public class Sulotion {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        codeHelper(root, res);
        return res;
    }

    public void codeHelper(Node root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            for (Node node : root.children) {
                codeHelper(node, res);
            }
        }
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
