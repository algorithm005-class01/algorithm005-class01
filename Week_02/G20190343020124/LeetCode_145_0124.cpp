/*
 * @lc app=leetcode.cn id=145 lang=cpp
 *
 * [145] 二叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (68.84%)
 * Likes:    195
 * Dislikes: 0
 * Total Accepted:    42K
 * Total Submissions: 60.7K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]  
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3 
 * 
 * 输出: [3,2,1]
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode *> st;
        if (root) {
            st.push(root);
        }
        while (!st.empty()) {
            root = st.top();
            st.pop();
            res.insert(res.begin(), root->val);
            if (root->left) {
                st.push(root->left);
            }
            if (root->right) {
                st.push(root->right);
            }
        }
        return res;
    }

    // 另一种迭代写法
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode *> st;
        while (root || !st.empty()) {
            while (root) {
                st.push(root);
                res.insert(res.begin(), root->val);
                root = root->right;
            }
            root = st.top(); st.pop();
            root = root->left;
        }
        return res;
    }

    // 递归
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        helper(root, res);
        return res;
    }
    void helper(TreeNode *root, vector<int> &res)
    {
        if (root)
        {
            helper(root->left, res);
            helper(root->right, res);
            res.push_back(root->val);
        }
    }
};
// @lc code=end

