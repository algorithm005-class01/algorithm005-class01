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
    int minDepth(TreeNode* root) {
        if (root == NULL)
            return 0;
        if (root->left == NULL && root->right == NULL)
            return 1;
        int min_depth = INT_MAX;
        if (root->left)
            min_depth = min(minDepth(root->left), min_depth);
        if (root->right)
            min_depth = min(minDepth(root->right), min_depth);
        return min_depth + 1;
    }
};