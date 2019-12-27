/**
 * 给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
*/

#include <iostream>
#include <vector>
#include <stack>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class SolutionColor
{
public:
    vector<int> inorderTraversal(TreeNode *root)
    {
        if (root == NULL)
            return {};
        int white = 0, gray = 1;
        vector<int> ans;
        stack<pair<int, TreeNode *>> st;
        st.push(make_pair(white, root));

        // 循环所用的变量
        TreeNode *node = NULL;
        int color = 0, size = 0;
        while (!st.empty())
        {
            // 取出栈顶元素
            node = st.top().second;
            color = st.top().first;
            st.pop();
            if (color == white)
            {
                if (node->right != NULL)
                {
                    st.push(make_pair(white, node->right));
                }
                st.push(make_pair(gray, node));
                if (node->left != NULL)
                {
                    st.push(make_pair(white, node->left));
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

/**
 * 所有解法的总结 
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/die-dai-fa-by-jason-2/
 * 
 * 其实最简单的是颜色标记法, 记录走过的路径,根据不同的颜色状态 决定左什么
 * 
*/
class Solution
{
public:
    vector<int> inorderTraversal(TreeNode *root)
    {
        if (root == NULL)
            return {};
        vector<int> ans;
        stack<TreeNode *> st;

        // 左 根  右
        TreeNode *cur = root;
        while (cur != NULL || !st.empty())
        {
            // 这里没有右子树的元素 ( cur ) 则会跳过
            while (cur)
            {
                st.push(cur);
                cur = cur->left;
            }
            // 上面是 将根元素的最左子树的..... 左元素赋值到cur
            // 取出栈顶元素
            cur = st.top();
            st.pop();
            // 记录该元素
            ans.push_back(cur->val);
            // 这里最关键,更新右子树根节点为 cur, 循环调用
            cur = cur->right;
        }
        return ans;
    }
};

int main()
{
    return -1;
}