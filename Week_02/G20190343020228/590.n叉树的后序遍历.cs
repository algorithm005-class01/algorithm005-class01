/*
 * @lc app=leetcode.cn id=590 lang=csharp
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
/*
// Definition for a Node.
public class Node {
    public int val;
    public IList<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, IList<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/
public class Solution {

    public IList<int> Postorder(Node root) {
        List<int> result = new List<int>();
        if(root==null)
            return result;
        
        
        return result;
    }
 
    public IList<int> PostorderWithRecursive(Node root) {
        List<int> result = new List<int>();
        if(root==null)
            return result;
        helper(root, result);
        return result;
    }

    private void helper(Node node, List<int> result){
        if(node.children!=null&&node.children.Count>0){
            foreach(Node cnode in node.children){
                if(cnode!=null)
                    helper(cnode,result);
            }
        }
        result.Add(node.val);
    }
}
// @lc code=end

