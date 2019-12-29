package main.leetcode_solutions.tree;

import main.common.Node;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019/12/20
 */
public class T590_NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(Node root, List<Integer> list){
        if (root == null) {
            return;
        }
        if (root.children != null){
            for (Node child : root.children){
                dfs(child, list);
            }
        }
        list.add(root.val);
    }
}
