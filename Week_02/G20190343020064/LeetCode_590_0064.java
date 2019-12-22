package G20190343020064;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * N叉树的后序遍历
 * </p>
 *
 * @author mingke.yan  2019-12-20 3:27 下午
 */
public class LeetCode_590_0064 {


    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        traversal(root,list);
        return list;
    }

    public void traversal(Node root,List<Integer> list) {
        if (root == null) {
            return;
        }
        List<Node> children = root.children;
        for (int i = 0; i < children.size(); i++) {
            traversal(children.get(i),list);
        }
        list.add(root.val);
    }

}
