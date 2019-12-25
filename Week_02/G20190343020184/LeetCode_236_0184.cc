#include <iostream>
#include <vector>

using namespace std;

struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x)
	: val(x)
	, left(NULL)
	, right(NULL)
    {
    }
};

//这个嘛。。。
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q)
    {
	if (root == nullptr || root == p || root == q)
	    return root;
	//查看左子树中是否有目标结点，没有为null
	TreeNode* left = lowestCommonAncestor(root->left, p, q);
	//查看右子树是否有目标节点，没有为null
	TreeNode* right = lowestCommonAncestor(root->right, p, q);
	//都不为空，说明做右子树都有目标结点，则公共祖先就是本身
	if (left != nullptr && right != nullptr)
	    return root;
	//如果发现了目标节点，则继续向上标记为该目标节点
	return left == nullptr ? right : left;
    }
};

int main(int argc, char* argv[])
{

    return 0;
}
