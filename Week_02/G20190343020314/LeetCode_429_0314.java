package week02;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: N叉树的层序遍历.
 *
 * @author Wengy
 * @since JDK 1.8
 * @since 1.0.0
 */
public class LeetCode_429_0314 {
  
  public List<List<Integer>> levelOrder(Node root) {
    
    
    List<List<Integer>> resultList = new ArrayList<>();
    if(root==null) {
      return resultList;
    }
    Deque<Node> dQueue = new LinkedList<>();
    dQueue.offerFirst(root);
    while(dQueue.size()>0) {
      List<Node> nodes = new ArrayList<>();
      List<Integer> tempList = new ArrayList<>();
      while(dQueue.size()>0) {
        
        Node node = dQueue.pollLast();
        tempList.add(node.val);
        nodes.add(node);
      }
      resultList.add(tempList);
      
      for(Node node : nodes) {
        for(Node e : node.children) {
          dQueue.offerFirst(e);
        }
      }
    }
    
    
    return resultList;
    
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