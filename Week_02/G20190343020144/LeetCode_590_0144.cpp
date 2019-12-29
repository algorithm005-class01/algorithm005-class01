/*
给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3叉树 :

      1
  3    2     4
5  6
 

返回其后序遍历: [5,6,3,2,4,1].
 

说明: 递归法很简单，你可以使用迭代法完成此题吗?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

class Solution_Color
{
public:
    vector<int> postorder(Node *root)
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
                st.push(make_pair(gray, node));
                size = node->children.size();
                if (size != 0)
                {
                    // 从前往后遍历子元素
                    for (int i = 0; i < size; i++)
                    {
                        st.push(make_pair(white, node->children[size - i - 1]));
                    }
                }
            }
            else
            {
                ans.push_back(node->val);
            }
        }
        return ans;
    }
};

class SolutionIterator
{
public:
    vector<int> postorder(Node *root)
    {
        if (root == NULL)
            return {};

        vector<int> ans;
        stack<Node *> st;
        st.push(root);

        // 左 右 根  这里的做法是 我们先 根 右 左 , 然后在 反转以下
        int size;
        Node *node = NULL;
        while (!st.empty())
        {
            // 取出栈顶元素
            node = st.top();
            st.pop();
            ans.push_back(node->val);
            size = node->children.size();
            if (size != 0)
            {
                // 从前往后遍历子元素
                for (int i = 0; i < size; i++)
                {
                    st.push(node->children[i]);
                }
            }
        }

        // 反转, 去掉这个是前序, 哈哈
        reverse(ans.begin(), ans.end());
        return ans;
    }
};

/**
 * 前序和后续的解法 一致  while (!st.empty()) node = st.top(); st.pop(); ans.push_back(node->val);
 * 中序(左根右)另一种 while (cur!= NULL || !st.empty()) while(cur) {cur = cur.left};
 * 层级另一种 :队列 - level - size
 * 
*/

int main()
{
    Node node = Node(1);
    Solution_Color().postorder(&node);
    return -1;
}