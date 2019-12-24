package main.leetcode_solutions.tree;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019/12/20
 */
public class T589_NaryTreePreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    private void dfs(Node root, List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        if (root.children == null){
            return;
        }
        for (Node child : root.children){
            dfs(child, list);
        }
    }
}