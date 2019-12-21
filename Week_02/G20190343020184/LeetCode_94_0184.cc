#include <iostream>
#include <stack>
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

void inorderTraversalRe(TreeNode* root, vector<int>& result)
{
    if (root != NULL) {
	inorderTraversalRe(root->left, result);
	result.push_back(root->val);
	inorderTraversalRe(root->right, result);
    }
}

//递归
vector<int> inorderTraversal(TreeNode* root)
{
    vector<int> result;
    inorderTraversalRe(root, result);
    return result;
}

//非递归的思路也不難理解，就是不停的遍历左边就好了
//参考别人代码

class Solution {
public:
    vector<int> result;
    vector<int> inorderTraversal(TreeNode* root)
    {
	if (root == NULL) {
	    return result;
	}
	Traversal(root);
	return result;
    }

    void Traversal(TreeNode* root)
    {
	stack<TreeNode*> s;
	while (root != NULL || !s.empty()) {
	    while (root != NULL) {
		s.push(root);
		root = root->left;
	    }
	    if (!s.empty()) {
		root = s.top();
		result.push_back(root->val);
		s.pop();
		root = root->right;
	    }
	}
    }
};

int main()
{
}
