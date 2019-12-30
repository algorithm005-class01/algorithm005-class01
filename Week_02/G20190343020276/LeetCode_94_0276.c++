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
    vector<int> result; 
public:
    vector<int> inorderTraversal(TreeNode* root) 
    {
        
        if(root == NULL)
            return vector<int>();

        // inorderTraversal(root->left);
        // result.push_back(root->val);
        // inorderTraversal(root->right);

        // return result;

        vector<int> res;
        stack<TreeNode> s;
        TreeNode *t = root;
        while(t != NULL || !s.empty())
        {
            while(t != NULL)
            {
                s.push(*t);
                t = t->left;
            }

            if(!s.empty())
            {
                res.push_back(s.top().val);
                t = s.top().right;
                s.pop();
            }

        }
        return res;
    }
};