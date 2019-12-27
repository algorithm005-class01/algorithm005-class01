package main.leetcode_solutions.tree;

import main.common.Node;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019/12/20
 */
public class T429_NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++){
                Node node = queue.poll();
                for (Node child : node.children){
                    queue.offer(child);
                }
                level.add(node.val);
            }
            res.add(level);
        }
        return res;
    }
}
