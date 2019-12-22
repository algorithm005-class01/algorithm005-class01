package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
/*
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
*/


//按递归模板写，但没有完成写出来，不是预期结果
//解法1，最接近自己预期的想法的解法,有点冗余
class Solution5 {
    public static class Node {
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
    };

    //总结果
    private List<List<Integer>> lists = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(Node root) {
        //初始化
        ArrayList<Node> tempList = new ArrayList<Node>();
        //根结点
        tempList.add(root);

        if (root != null && root.children != null) {
            //drill down
            level(tempList);
        }
        return lists;
    }

    private void level(ArrayList<Node> list) {

        if (list.size() == 0)
            return;

        //存下层子结点
        ArrayList<Node> childList = new ArrayList<Node>();

        //当前层输出数组
        ArrayList<Integer> currList = new ArrayList<Integer>();

        //遍历此层的children
        for (Node node : list) {
            //输出当前层的val  
            currList.add(node.val);

            //存每个结点的child,准备给下一层，继续 drill down
            if (node.children.size() > 0) {
                childList.addAll(node.children);
            }
        }

        lists.add(currList);

        level(childList);
    }

    public static void main(String[] args) {

        Solution5 sol = new Solution5();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        List<Node> nodeArr1 = new ArrayList<Node>();
        nodeArr1.add(node3);
        nodeArr1.add(node2);
        nodeArr1.add(node4);

        List<Node> nodeArr2 = new ArrayList<Node>();
        nodeArr2.add(node5);
        nodeArr2.add(node6);

        node1.children = nodeArr1;
        node3.children = nodeArr2;

        System.out.println(sol.levelOrder(node1));
    }
}

//递归
class Solution11 {
    public static class Node {
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
    };
    
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        helper(root, 0, res);
        return res;
    }
    
    private void helper(Node root, int depth, List<List<Integer>> res) {
        if (root == null) return;
        //判断是否是新的一层
        if (depth + 1 > res.size()) {
            //res没有这层 插入新的数组，代表新的层数
            res.add(new ArrayList<>());
        }
        //若有这层，在当前层插入
        res.get(depth).add(root.val);
    
        //处理子节点
        for (Node node : root.children) {
            if (node != null) {
                helper(node, depth + 1, res);
            }
        }
    }
}

//解法2，思路清楚，优秀
// 思路：bfs进行树的层序遍历，关键：每层的节点数等于此时queue的size
class Solution {
    public static class Node {
        public int val;
        public List < Node > children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List < Node > _children) {
            val = _val;
            children = _children;
        }
    };

    List < List < Integer >> ans = new ArrayList < > ();

    // 思路：bfs进行树的层序遍历，关键：每层的节点数等于此时queue的size
    public List < List < Integer >> levelOrder(Node root) {
        bfs(root);
        return ans;
    }

    private void bfs(Node root) {
        if (root == null) {
            return;
        }

        //先进先去 FIFO
        Queue < Node > queue = new LinkedList < > ();
        //根入队列
        queue.add(root);

        while (!queue.isEmpty()) {
            //当前层队列的大小
            int size = queue.size();
            //存当前层的节点val的数组
            List < Integer > one = new ArrayList < > ();

            //遍历当前层的大小
            while (size-- > 0) {
                //节点队头出队
                Node n = queue.poll();
                //输出
                one.add(n.val);

                //有子结点，队尾入队，留着给下一层遍历
                queue.addAll(n.children);
            }
            //总输出
            ans.add(one);
        }
    }
}
// @lc code=end