package com.android.browser.newhome.news.login;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的后序遍历
 * N叉树的后序遍历和前序遍历区别就在于是先遍历还是先存value
 */
public class LeetCode_590_0010 {

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
    class Solution {
        // public List<Integer> postorder(Node root) {
        //     List<Integer> list = new ArrayList();

        //     getValue(root, list);

        //     return list;

        // }

        // public static void getValue(Node root, List<Integer> list){
        //     if(root != null && root.children != null){
        //         for(int i = 0; i < root.children.size(); i++){
        //             Node children = root.children.get(i);
        //             getValue(children, list);
        //         }
        //     }
        //     if(root != null){
        //         list.add(root.val);
        //     }
        // }
    }
}
