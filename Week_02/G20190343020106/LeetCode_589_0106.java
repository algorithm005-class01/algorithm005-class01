package Week2_0106;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        res.add(root.val);

        if (root.children.size() > 0) {
            for(int i=0;i<root.children.size();i++){
                List<Integer> temp = preorder(root.children.get(i));

                res.addAll(temp);
            }
        }
        return res;
    }
}

// Definition for a Node.
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
