/**
 * 
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]



 

示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 

说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。




这道题是 LCA 可以使用 RMQ解决


 * 
*/

#include <iostream>
#include <vector>
#include <stack>
#include <unordered_map>
#include <set>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

/***
 * 刚看到这个题目, 完全没有思路
 * 全部算法有
 * 递归
 * 父指针迭代
 * RMQ预处理算法
 * 
*/

class SolutionRecursion
{
public:
    TreeNode *ans;
    TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q)
    {
        containLowestCommonAncestor(root, p, q);
        return ans;
    }

    bool containLowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q)
    {
        if (root == NULL)
            return false;
        // 左子树
        int left = containLowestCommonAncestor(root->left, p, q) ? 1 : 0;
        // 右子树
        int right = containLowestCommonAncestor(root->right, p, q) ? 1 : 0;
        // 中间
        int middle = (root == p || root == q) ? 1 : 0;

        // 最小公共节点, 三种情况 一: 左子树 + 右子树 二: 左子树 + root 三: 右子树 + root
        if ((middle + left + right) >= 2)
        {
            ans = root;
        }

        // 是否包含其中一个节点 (p或者q)
        return (middle + left + right);
    }
};

/**
 * 这种方式还不如递归来的快 😓
 * 
*/
class SolutionIterator
{
public:
    TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q)
    {
        if (root == NULL)
            return NULL;
        unordered_map<TreeNode *, TreeNode *> parent_map;
        // 遍历树, 一直找到p和q, 同时记录父节点
        stack<TreeNode *> st;
        st.push(root);
        TreeNode *cur = NULL;
        while (!st.empty() && (parent_map.find(p) == parent_map.end() || parent_map.find(q) == parent_map.end()))
        {
            cur = st.top();
            st.pop();
            if (cur->left != NULL)
            {
                st.push(cur->left);
                parent_map[cur->left] = cur;
            }
            if (cur->right != NULL)
            {
                st.push(cur->right);
                parent_map[cur->right] = cur;
            }
        }

        set<TreeNode *> s;
        while (p)
        {
            s.insert(p);
            p = parent_map[p];
        }

        // 回溯父节点, 找公共父节点即可
        while (q)
        {
            if (s.find(q) != s.end())
            {
                return q;
            }
            else
            {
                q = parent_map[q];
            }
        }

        return q;
    }
};

/**
 * 后序遍历 预处理, 然后从后向前查找最小公共祖先, 后续一步一步的找
 * 
 * 
*/
class Solutionorder
{
public:
    TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q)
    {
        if (root == NULL)
            return NULL;
        stack<TreeNode *> record;
        stack<TreeNode *> help;
        record.push(root);

        // 预处理
        while (!record.empty())
        {
            TreeNode *cur = record.top();
            help.push(cur);
            record.pop();

            if (cur->left != NULL)
                record.push(cur->left);
            if (cur->right != NULL)
                record.push(cur->right);
        }

        // 一步一步比较
        while (!help.empty())
        {
            TreeNode *node = help.top();

            if (node->left != NULL && node->left->val == p->val)
                p->val = node->val;
            if (node->right != NULL && node->right->val == p->val)
                p->val = node->val;
            if (node->left != NULL && node->left->val == q->val)
                q->val = node->val;
            if (node->right != NULL && node->right->val == q->val)
                q->val = node->val;

            if (p->val == q->val)
                return p;

            help.pop();
        }
        return NULL;
    }
};

// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/4chong-jie-by-cnkoala/
int main()
{
    return -1;
}