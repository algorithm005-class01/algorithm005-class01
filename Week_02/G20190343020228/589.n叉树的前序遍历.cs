/*
 * @lc app=leetcode.cn id=589 lang=csharp
 *
 * [589] N叉树的前序遍历
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

    public Node(int _val,IList<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/
public class Solution {
    public IList<int> Preorder(Node root){
        List<int> result = new List<int>();
        if(root==null) 
            return result;
        Stack<Node> stack = new Stack<Node>();
        stack.Push(root);
        while(stack.Count>0){
            Node curr = stack.Pop();
            result.Add(curr.val);
            IList<Node> clist = curr.children;
            for(int i = clist.Count-1;i>=0;i--){
                stack.Push(clist[i]);
            }
        }
        return result;
    }
    public IList<int> PreorderWithRecursive(Node root) {
        List<int> result = new List<int>();
        if(root==null) 
            return result;

        helper(root, result);
        return result;
    }

    private void helper(Node node, List<int> result){
        if(node==null) return;

        result.Add(node.val);
        if(node.children!=null&&node.children.Count>0){
            foreach(Node cnode in node.children){
                if(cnode!=null)
                    helper(cnode,result);
            }
        }
    }
}
// @lc code=end

