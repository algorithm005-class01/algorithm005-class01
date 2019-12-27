/**
 * 
 根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/

#include <iostream>
#include <vector>
#include <unordered_map>
#include <stack>
using namespace std;

struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

/**
 *  前序 根-左-右
 *  中序 左 - 根 - 右
 * 
 * ① 根据前序的 root 将 中序的数组分为 左子树与 右子树 
 * ② 然后根据 前序的 value 获取到 中序的 该节点对应在中序的索引, // 可以这么做的前提是 因为没有重复的数字, 否则无法这么做 !!!!!!!!
 * ③ 回到①
*/
class Solution
{
public:
    // 前序的即将构建的节点索引
    int preorderIndex;
    // 中序的 value - index 构建的map
    unordered_map<int, int> inorderMap;
    vector<int> pre;

    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder)
    {
        if (preorder.size() == 0 || inorder.size() == 0)
            return NULL;
        preorderIndex = 0;
        // 这里类成员与传参同名出现问题;
        // 同名希望两个指针都指向同一个存储空间，但是，实际上两个指针没有指向一个存储空间，一个指针指向了存储空间，而一个是空指针，所以就出现了错误
        // 如果你想重名的话，成员变量前面应该加this指针
        pre = preorder;

        for (int i = 0; i < inorder.size(); i++)
        {
            inorderMap[inorder[i]] = i;
        }
        // 创建根节点, 注意这里 right需要传值 inorder.size() 否则会出现丢失尾部节点的问题
        return _helper(0, inorder.size());
    }

    /**
     * 构建某个节点的 help 
     * @param left 节点所在 子树的 边界, 注意 left 为闭区间
     * @param right 节点所在的 子树 边界, 注意 right是开区间
     * 
    */
    TreeNode *_helper(int left, int right)
    {
        if (left == right)
            return NULL;
        int value = pre[preorderIndex];
        TreeNode *root = new TreeNode(value);
        int inorderIndex = inorderMap[value];

        // 注意这里右移 前序的节点索引
        preorderIndex++;
        // 获取左节点 注意这里是 不能将左节点与右节点的创建顺序改变的, 因为它们都依赖与 preorderIndex 的值, 是有先后顺序的 , 没有实现方法的正交行
        // 注意 是 (left, inorderIndex) 而不是 (left, inorderIndex - 1);
        root->left = _helper(left, inorderIndex);
        root->right = _helper(inorderIndex + 1, right);
        return root;
    }
};

/**
 * 另一个解法是 用栈迭代处理 
 * 有些难懂, 暂时不去学习这种方法
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
 * 
*/

class SolutionIterator
{
public:
    TreeNode *buildTree(vector<int> &pre, vector<int> &in)
    {
        if (pre.empty())
            return NULL;
        stack<TreeNode *> S;
        TreeNode *root = new TreeNode(pre[0]);
        S.push(root);
        for (int i = 1, j = 0; i < pre.size(); i++)
        { // i-前序序号，j-中序序号
            TreeNode *back = NULL, *cur = new TreeNode(pre[i]);
            while (!S.empty() && S.top()->val == in[j])
                back = S.top(), S.pop(), j++;
            if (back)
                back->right = cur;
            else
                S.top()->left = cur;
            S.push(cur);
        }
        return root;
    }
};

void printArr(vector<int> &arr)
{
    for (int i = 0; i < arr.size(); i++)
    {
        cout << arr[i];
    }
    cout << endl;
};

int main(int argc, char **argv)
{
    vector<int> preorder = {3, 9, 20, 15, 7};
    vector<int> inorder = {9, 3, 15, 20, 7};
    TreeNode *root = Solution().buildTree(preorder, inorder);
    cout << root->val << endl;
    return -1;
}