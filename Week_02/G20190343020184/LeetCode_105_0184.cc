#include <iostream>
#include <map>
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

//自己的代码
TreeNode* pro(map<int, int>& recmap, vector<int>& preorder, vector<int>& inorder, int begin1, int end1, int begin2, int end2)
{
    if ((begin1 > end1) || (begin2 > end2)) {
	return nullptr;
    }
    if ((begin1 == end1) && (begin2 == end2)) {
	return new TreeNode(preorder[begin1]);
    }
    int pos = recmap[preorder[begin1]];
    TreeNode* res = new TreeNode(preorder[begin1]);
    int leftlong = pos - begin2 + 1;
    int rightlong = end2 - pos + 1;
    TreeNode* left = pro(recmap, preorder, inorder, begin1 + 1, begin1 + leftlong, begin2, pos - 1);
    TreeNode* right = pro(recmap, preorder, inorder, begin1 + 1 + leftlong, begin1 + leftlong + rightlong, pos + 1, end2);
    res->left = left;
    res->right = right;
    return res;
}

TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder)
{
    if (preorder.size() == 0 || inorder.size() == 0) {
	return nullptr;
    }
    map<int, int> recmap;
    for (int i = 0; i < inorder.size(); ++i) {
	recmap.insert({ inorder[i], i });
    }
    return pro(recmap, preorder, inorder, 0, preorder.size() - 1, 0, inorder.size() - 1);
}

//参考的代码
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder)
    {
	int l1 = 0;
	int l2 = 0;
	int r1 = preorder.size() - 1;
	int r2 = inorder.size() - 1;
	TreeNode* s = (TreeNode*)malloc(sizeof(TreeNode));
	//s = NULL;
	s = CreateBT(preorder, inorder, l1, r1, l2, r2);
	return s;
    }

    TreeNode* CreateBT(vector<int>& preorder, vector<int>& inorder, int l1, int r1, int l2, int r2)
    {
	TreeNode* s;
	int i;
	if (l1 > r1)
	    return NULL;
	s = (TreeNode*)malloc(sizeof(TreeNode));
	s->left = s->right = NULL;
	for (i = l2; i <= r2; i++) {
	    if (inorder[i] == preorder[l1]) {
		break;
	    }
	}
	s->val = inorder[i];
	s->left = CreateBT(preorder, inorder, l1 + 1, l1 + i - l2, l2, i - 1);
	s->right = CreateBT(preorder, inorder, l1 + i - l2 + 1, r1, i + 1, r2);
	return s;
    }
};

int main(int argc, char* argv[])
{

    return 0;
}
