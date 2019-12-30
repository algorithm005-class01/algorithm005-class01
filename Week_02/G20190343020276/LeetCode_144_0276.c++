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
    vector<int> preorderTraversal(TreeNode* root) {
    // 方法一：递归
        // if(root == NULL)
        //     return result;
        // result.push_back(root->val);
        // preorderTraversal(root->left);
        // preorderTraversal(root->right);
        // return result;
        vector<int> res;
        if(root == NULL)
            return res;
        stack<TreeNode*> s;
        TreeNode *tn = root;
        // res.push_back(root->val);
        s.push(root);

        while(!s.empty())
        {
            tn = s.top();
            s.pop();
            res.push_back(tn->val);
            if(tn->right)
            {
                s.push(tn->right);
            }

            if(tn->left)
            {
                s.push(tn->left);
            }
        }
        return res;
    }
};