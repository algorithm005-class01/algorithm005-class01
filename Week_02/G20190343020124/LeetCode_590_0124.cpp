/*
 * @lc app=leetcode.cn id=590 lang=cpp
 *
 * [590] N叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (70.82%)
 * Likes:    40
 * Dislikes: 0
 * Total Accepted:    12.9K
 * Total Submissions: 18.2K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]\r'
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
// 递归
    vector<int> postorder(Node *root)
    {
        vector<int> res;
        postorderN(root, res);
        return res;
    }

    void postorderN(Node *root, vector<int> &res)
    {
        if (!root)
            return;
        vector<Node *> children = root->children;
        for (auto it : children)
        {
            postorderN(it, res);
        }
        res.push_back(root->val);
    }
    // 非递归
    vector<int> postorder(Node *root)
    {
        vector<int> res;
        if (!root)
            return res;
        stack<Node *> st;
        st.push(root);
        while (!st.empty())
        {
            root = st.top();
            res.push_back(root->val);
            st.pop();
            vector<Node *> children = root->children;
            for (auto i : children)
            {
                st.push(i);
            }
        }
        reverse(res.begin(), res.end());
        return res;
    }
};
// @lc code=end

