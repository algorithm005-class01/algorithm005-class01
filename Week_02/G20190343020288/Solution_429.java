package week_02.commit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 429. N叉树的层序遍历
// https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
public class Solution_429 {

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null)
            return result;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curr = queue.poll();
                curLevel.add(curr.val);
                if (null != curr.children) {
                    for (Node c : curr.children)
                        queue.offer(c);
                }
            }
            result.add(curLevel);
        }
        return result;
    }
}
