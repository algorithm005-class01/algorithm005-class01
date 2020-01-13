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

vector<vector<int> > results;
private:
    void levelOrder(TreeNode* root,int level)
    {
        if(root == nullptr)
        {
            return;
        }
        if(results.size() == level)
        {
            results.push_back(vector<int>());
        }
        results[level].push_back(root->val);
        levelOrder(root->left,level+1);
        levelOrder(root->right,level+1);
    }
public:
    vector<vector<int>> levelOrder(TreeNode* root)
    {
        levelOrder(root,0);
        return results;
    }
    // vector<vector<int>> levelOrder(TreeNode* root) 
    // {
    //     //BFS
    //     vector<vector<int> > results;
    //     // vector<int> result;
    //     if(root == nullptr)
    //         return results;
    //     // int currentLevel = 1;
    //     // int nextLevel = 0;
    //     queue<TreeNode*> q;
    //     q.push(root);
    //     while(!q.empty())
    //     {
    //         vector<int> result;
    //         int qSize = q.size();
    //         for(int i=0;i<qSize;i++)
    //         {
    //             TreeNode * node = q.front();
    //             result.emplace_back(node->val);
    //             if(node->left) q.push(node->left);
    //             if(node->right) q.push(node->right);
    //             q.pop();
    //         }
    //         results.emplace_back(result);
            
    //     //     TreeNode * node = q.front();
    //     //     result.emplace_back(node->val);
    //     //     q.pop();
    //     //     currentLevel--;
    //     //     if(node->left != nullptr)
    //     //     {
    //     //         q.push(node->left);
    //     //         nextLevel++;

    //     //     }
    //     //     if(node->right != nullptr)
    //     //     {
    //     //         q.push(node->right);
    //     //         nextLevel++;
    //     //     }

    //     //     if(currentLevel == 0)
    //     //     {
    //     //         results.emplace_back(result);
    //     //         result.clear();
    //     //         currentLevel = nextLevel;
    //     //         nextLevel = 0;
    //     //     }
    //     }
    //     return results;
    // }
};
