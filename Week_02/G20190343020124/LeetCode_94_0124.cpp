/*
 * @lc app=leetcode.cn id=94 lang=cpp
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (69.02%)
 * Likes:    341
 * Dislikes: 0
 * Total Accepted:    84.5K
 * Total Submissions: 122.1K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
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
 * 输出: [1,3,2]
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
#include<vector>
#include<stack>
using namespace std;

class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {

        vector<int> res;
        stack<TreeNode *> st;
        while (root || !st.empty())
        {
            if (root)
            {
                st.push(root);
                root = root->left;
            }
            else
            {
                root = st.top();
                res.push_back(root->val);
                st.pop();
                root = root->right;
            }
        }

        return res;
    }

};
// @lc code=end

