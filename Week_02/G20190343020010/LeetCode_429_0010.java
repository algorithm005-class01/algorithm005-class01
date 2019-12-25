package com.android.browser.newhome.news.login;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的层序遍历
 */
public class LeetCode_429_0010 {


    class Node {
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


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList();

        getValue(root, 0, list);

        return list;

    }


    public void getValue(Node root, int depth, List<List<Integer>> list) {
        if (root == null) {
            return;
        }

        if (depth + 1 > list.size()) {
            list.add(new ArrayList<Integer>());
        }

        list.get(depth).add(root.val);

        for (Node node : root.children) {
            getValue(node, depth + 1, list);
        }

    }
}
