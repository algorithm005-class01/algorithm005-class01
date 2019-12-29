package week02;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: N叉树的后序遍历.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_590_0314 {
  
  public List<Integer> postorder(Node root) {
    
    List<Integer> list = new ArrayList<>();
    if(root==null) {
      return list;
    }
    
    for(Node node : root.children) {
      list.addAll(postorder(node));
    }
    
    list.add(root.val);
    
    return list;
  }
  
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

}