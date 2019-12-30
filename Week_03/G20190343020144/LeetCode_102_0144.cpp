
#include <iostream>
#include <vector>
#include <queue>
using namespace std;


struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
  };


/**
 * queue 层级遍历
 * 
 * c++ 语法注意: 
 * 结构体指针用 - >
 * queue用 push / front pop
 * 
*/
class SolutionDFS {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> ans;
        if (root == NULL) return ans;
        queue<TreeNode *> q;
        q.push(root);
        // 可以不记录 levelCount, 直接用 q.size()即可 优化以下
        int levelCount = 1;
        int n_levelCount = 0;
        while (!q.empty()) {
            int n_levelCount = 0;
            vector<int> vs;
            for (int i = 0; i < levelCount ; i++) {
                TreeNode *node = q.front();
                q.pop();
                // 指针用
                vs.push_back(node->val);
                if (node->left) {
                    q.push(node->left);
                    n_levelCount ++;
                }
                if (node->right) {
                    q.push(node->right);
                    n_levelCount ++;
                }
            }
            levelCount = n_levelCount;
            ans.push_back(vs);
        }
        return ans;
    }

    vector<vector<int>> levelOrderNew(TreeNode* root) {
        vector<vector<int>> ans;
        if (root == NULL) return ans;
        queue<TreeNode *> q;
        q.push(root);
        // 可以不记录 levelCount, 直接用 q.size()即可 优化以下
        int levelCount = q.size();
        while (!q.empty()) {
            vector<int> vs;
            for (int i = 0; i < levelCount ; i++) {
                TreeNode *node = q.front();
                q.pop();
                vs.push_back(node->val);
                if (node->left) q.push(node->left);
                if (node->right) q.push(node->right);
            }
            levelCount = q.size();
            ans.push_back(vs);
        }
        return ans;
    }
};

// BFS 记录 level 添加到数组

// 递归
