
#include <iostream>
#include <vector>
#include <stack>
#include <unordered_map>

using namespace std;

/// 前序 根 -> 左 -> 右; ① 递归 ② dfs 深度优先处理 ③ 颜色标记处理(万能)

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

class Solution_Recursive
{
public:
    vector<int> preorder(Node *root)
    {
        vector<int> ans;
        preorder(root, ans);
        return ans;
    }

    void preorder(Node *root, vector<int> &ans)
    {
        if (root != NULL)
        {
            ans.push_back(root->val);
        }

        for (Node *node : root->children)
        {
            preorder(node, ans);
        }
    }
};

/**
 * 迭代法
 * 先不写细节, 先注意骨架
 * 然后补充细节
 * 
 *             // ① 取出栈顶元素 , 打印
 *             // ② 从前往后遍历子元素, 添加到栈中  
 *             // 回到 ①处
*/
class Solution_Iterator
{
public:
    vector<int> preorder(Node *root)
    {
        if (root == NULL)
            return {};
        vector<int> ans;
        stack<Node *> st;
        st.push(root);
        Node *cur = NULL;
        int size = 0;
        while (!st.empty())
        {
            // 取出栈顶元素
            cur = st.top();
            st.pop();
            ans.push_back(cur->val);
            size = cur->children.size();
            if (size == 0)
                continue;
            // 从前往后遍历子元素
            for (int i = 0; i < size; i++)
            {
                st.push(cur->children[size - i - 1]);
            }
            // ... 循环 取出元素, 再从前往后遍历子元素
        }
        return ans;
    }
};

/**
 * 颜色标记法, 可以用于 前后中序 遍历
 * 具体分析可以看这个示例 : https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/yan-se-biao-ji-fa-yi-chong-tong-yong-qie-jian-ming/
*/
class Solution_Color
{
public:
    vector<int> preorder(Node *root)
    {
        if (root == NULL)
            return {};
        int white = 0, gray = 1;
        vector<int> ans;
        stack<pair<int, Node *>> st;
        st.push(make_pair(white, root));

        // 循环所用的变量
        Node *node = NULL;
        int color = 0, size = 0;
        while (!st.empty())
        {
            // 取出栈顶元素
            node = st.top().second;
            color = st.top().first;
            st.pop();
            if (color == white)
            {
                size = node->children.size();
                if (size != 0)
                {
                    // 从前往后遍历子元素
                    for (int i = 0; i < size; i++)
                    {
                        st.push(make_pair(white, node->children[size - i - 1]));
                    }
                }
                // 注意这里一定要进入的, 所以前面时 size != 0, 不能直接 size == 0 continue;的, 因为添加到ans是 颜色标记后才进行的
                st.push(make_pair(gray, node));
            }
            else
            {
                ans.push_back(node->val);
            }
        }
        return ans;
    }
};

int main()
{
    Node node = Node(1);
    Solution_Recursive().preorder(&node);
    return -1;
}