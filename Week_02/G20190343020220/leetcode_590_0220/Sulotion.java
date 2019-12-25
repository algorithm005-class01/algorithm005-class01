package G20190343020220.leetcode_590_0220;

import javax.xml.soap.Node;
import java.util.*;

/*给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3叉树 :

 



 

返回其后序遍历: [5,6,3,2,4,1].
*/

/**
 * @author Darcy
 * @date 2019-12-18 09:23
 */
public class Sulotion {


    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(result, root);
        return result;
    }

    private void postorderHelper(List<Integer> result, Node root) {
        if (root != null) {
            for (Node c : root.children) {
                postorderHelper(result, c);
            }
            result.add(root.val);
        }
    }

    public List<Integer> postorder1(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Deque<Node> s1 = new ArrayDeque<>();
        s1.addFirst(root);
        while (!s1.isEmpty()) {
            Node cur = s1.pollFirst();
            list.add(cur.val);
            for (Node children : cur.children) {
                s1.addLast(children);
            }
        }
        return list;
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
