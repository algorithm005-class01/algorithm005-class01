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
        stack<TreeNode*> sta;
        vector<int> res;
        TreeNode* curr = root;
        while(curr || !sta.empty())
        {
            while(curr) {
                res.push_back(curr->val);
                sta.push(curr->left);
                curr = curr->right;
            }
            curr = sta.top();
            sta.pop();
        }
        
        reverse(res.begin(), res.end());
        return res;
    }
};