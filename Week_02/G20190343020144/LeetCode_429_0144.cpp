/***
 * 
给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

例如，给定一个 3叉树 :

返回其层序遍历:

     [1],
     [3,2,4],
     [5,6]
]
 

说明:

树的深度不会超过 1000。
树的节点总数不会超过 5000。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
#include <stack>
using namespace std;

// 层级遍历时 先进先出

// Definition for a Node.
class Node
{
public:
    int val;
    vector<Node *> children;

    Node() {}

    Node(int _val)
    {
        val = _val;
    }

    Node(int _val, vector<Node *> _children)
    {
        val = _val;
        children = _children;
    }
};

/**
 * 使用队列层级遍历
 执行用时 :
88 ms
, 在所有 cpp 提交中击败了
92.39%
的用户
内存消耗 :
57.2 MB
, 在所有 cpp 提交中击败了
5.23%
的用户

对c++没有那么多了解, 不知道为什么内存消耗会这么大
 * **/
class Solution
{
public:
    vector<vector<int>> levelOrder(Node *root)
    {
        if (root == NULL)
            return {};

        vector<vector<int>> ans;
        // 模拟队列处理
        vector<Node *> queue;
        queue.push_back(root);
        int levelCount = 1;
        Node *cur = NULL;
        // 内存消耗比较大
        while (!queue.empty())
        {
            int n_level_count = 0;
            vector<int> levels;
            for (size_t i = 0; i < levelCount; i++)
            {
                cur = queue[i];
                levels.push_back(cur->val);
                if (cur->children.size() == 0)
                    continue;
                for (Node *it : cur->children)
                    queue.push_back(it);
                n_level_count += cur->children.size();
            }
            queue.erase(queue.begin(), queue.begin() + levelCount);
            levelCount = n_level_count;
            ans.push_back(levels);
        }
        return ans;
    }
};

int main()
{
    Node node = Node(1);
    Solution().levelOrder(&node);
    return -1;
}