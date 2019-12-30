/*
您需要在二叉树的每一行中找到最大的值。

示例：

输入: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

输出: [1, 3, 9]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

#include <iostream>
#include <vector>
#include <stack>
#include <queue>

using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

/**
 * 层级遍历 
 * 耗时: 执行用时 : 24 ms , 在所有 cpp 提交中击败了 36.63% 的用户
内存消耗 : 21 MB, 在所有 cpp 提交中击败了 83.12%的用户
 * 
*/
class Solution
{
public:
    vector<int> largestValues(TreeNode *root)
    {
        if (root == NULL)
        {
            return {};
        }
        vector<int> ans;
        // 层级遍历
        queue<TreeNode *> q;
        q.push(root);
        int size = q.size(), maxVal = 0;
        TreeNode *cur = NULL;
        while (!q.empty())
        {
            size = q.size();
            maxVal = INT_MIN;
            for (int i = 0; i < size; i++)
            {
                cur = q.front();
                q.pop();
                maxVal = max(cur->val, maxVal);
                if (cur->left)
                    q.push(cur->left);
                if (cur->right)
                    q.push(cur->right);
            }
            ans.push_back(maxVal);
        }
        return ans;
    }
};

/**
 递归 DFS 
 执行用时 :16 ms, 在所有 cpp 提交中击败了87.33%的用户
内存消耗 :21 MB, 在所有 cpp 提交中击败了81.17%的用户
 * 
*/
class SolutionDFS
{
public:
    vector<int> largestValues(TreeNode *root)
    {
        if (root == NULL)
        {
            return {};
        }
        vector<int> ans;
        large(root, 0, ans);
        // 层级遍历
        return ans;
    }

    void large(TreeNode *node, int level, vector<int> &ans)
    {
        if (node == NULL)
            return;
        // 根
        if (ans.size() > level)
        {
            ans[level] = max(ans[level], node->val);
        }
        else
        {
            ans.push_back(node->val);
        }
        // 左
        if (node->left)
        {
            large(node->left, level + 1, ans);
        }
        // 右
        if (node->right)
        {
            large(node->right, level + 1, ans);
        }
    }
};