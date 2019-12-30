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

    bool isValid(TreeNode *node,long lower,long upper)
    {
        if(node == nullptr)
            return true;
        else if(node->val <= lower || node->val >= upper)
            return false;

        else if(!isValid(node->right,node->val,upper) || !isValid(node->left,lower,node->val))
        {
            return false;
        }
        return true;
    }
    bool isValidBST(TreeNode* root) {
        
        return isValid(root,LONG_MIN,LONG_MAX);
    }
};