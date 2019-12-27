package G20190343020064;

import java.util.List;

/**
 * <p>
 * description
 * </p>
 *
 * @author mingke.yan  2019-12-20 3:27 下午
 */
public class Node {
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
}