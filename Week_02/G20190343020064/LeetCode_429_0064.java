package G20190343020064;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * N叉树的层序遍历
 * </p>
 *
 * @author mingke.yan  2019-12-20 3:38 下午
 */
public class LeetCode_429_0064 {



    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        traversal(root, 0, list);
        return list;
    }

    public void traversal(Node root, int depth, List<List<Integer>> list) {
        if (root == null) {
            return;
        }
        //===============================================================================
        // 当list长度 小于 深度时
        // 则新建当前层的 list
        // 否则直接在该层的 list 新增数据即可
        //
        //===============================================================================
        if (list.size() < depth + 1) {
            list.add(new ArrayList());
        }
        list.get(depth).add(root.val);

        //===============================================================================
        //  递归子节点
        //===============================================================================
        for (Node child : root.children) {
            traversal(child, depth + 1, list);
        }
    }

    /**
     * 层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Deque<Node> deque = new LinkedList<>();
        int level = 0;
        deque.add(root);

        while (!deque.isEmpty()){
            list.add(new ArrayList<>());
            int size = deque.size();
            for(int i = 0; i < size; i++) {
                Node node  = deque.remove();
                list.get(level).add(node.val);
                for (Node child : node.children) {
                    deque.add(child);
                }
            }
            level += 1;
        }
        return list;
    }
}
