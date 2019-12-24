/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

int TreeSize(struct TreeNode* root)
{
    if(root == NULL)    return 0;
 
    return TreeSize(root->left)+TreeSize(root->right)+1;

}
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* inorderTraversal(struct TreeNode* root, int* returnSize){
    int size = 0;   
    size = TreeSize(root);
    
 
    int p = -1,index = 0;

    if(root == NULL)  
    {
        *returnSize = 0;
        return NULL;
    }  
    struct TreeNode** src = malloc(sizeof(struct TreeNode*)*size);
    int *res =  (int *)malloc(sizeof(int)*size);

    while((p!=-1) || (root != NULL))
    {
        while(root)
        {
          src[++p] = root;
          root = root->left;
        }
        if(p != -1)
        {
          root = src[p--];
          res[index++] = root->val;
          root = root->right;
        }
    }
    *returnSize = index;
    return res;
}