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

    TreeNode* invertTree(TreeNode* root) {
       //先序
       //terminator
        if(root == NULL)
            return NULL;
        //process current logic
        // TreeNode * temp = root->left;
        // root->left = root->right;
        // root->right = temp;

        //drill down
        // invertTree(root->left);
        // invertTree(root->right);
        
        //中序
        // invertTree(root->left);
        
        // TreeNode * temp = root->left;
        // root->left = root->right;
        // root->right = temp;
        // invertTree(root->left);

        //后序
        invertTree(root->left);
        invertTree(root->right);
        TreeNode * temp = root->left;
        root->left = root->right;
        root->right = temp;   

        return root;
    }
};