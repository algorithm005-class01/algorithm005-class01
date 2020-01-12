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
private:
    vector<int> results;
    void dfs(TreeNode*node,int level)
    {
        if(results.size() == level)
        {
            results.push_back(INT_MIN);
        }
        results[level] = max(results[level],node->val);
        if(node->left) dfs(node->left,level+1);
        if(node->right) dfs(node->right,level+1);
    }
public:
    vector<int> largestValues(TreeNode* root) {
        if(root == nullptr)
            return results;
        dfs(root,0);
        return results;
    }
    // vector<int> largestValues(TreeNode* root) {
    //     if(root == nullptr)
    //         return vector<int>();
    //     vector<int> results;
    //     // results.push_back(root->val);
    //     queue<TreeNode*> q;
    //     q.push(root);
    //     while(!q.empty())
    //     {   
    //         int max = INT_MIN;
    //         TreeNode * temp = nullptr;
    //         int size = q.size();
    //         for(int i=0;i<size;++i)
    //         {
    //             temp = q.front();
    //             q.pop();
    //             if(max < temp->val)
    //             {
    //                 max = temp->val;
    //             }

    //         if(temp->left)
    //             q.push(temp->left);
    //         if(temp->right)
    //             q.push(temp->right);
    //         }
    //         results.push_back(max);
    //     }
    //     return results;
    // }
};
