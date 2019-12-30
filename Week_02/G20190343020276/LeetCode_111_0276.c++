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
    int minDepth(TreeNode* root) 
    {
        if(root == nullptr)
            return 0;
        return (root->left&&root->right) ? min(minDepth(root->left),minDepth(root->right)) + 1:
            1 + minDepth(root->left) + minDepth(root->right);
    }
};