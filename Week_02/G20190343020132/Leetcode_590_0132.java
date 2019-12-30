package org.azai.train.Week02;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_590_0132 {
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
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root,result);
        return result;
    }
    public void dfs (Node root,List<Integer> result) {
        if (root == null) {
            return;
        }
        for (Node node:root.children) {
            dfs(node,result);
        }
        result.add(root.val);
    }
}
