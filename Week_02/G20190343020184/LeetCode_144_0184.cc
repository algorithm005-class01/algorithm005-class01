#include <iostream>
#include <stack>
#include <vector>
using namespace std;

//老代码，直接拿来用
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

class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root)
    {
	if (root == nullptr) {
	    return {};
	}

	vector<int> res;
	stack<TreeNode*> st;
	st.push(root);
	while (!st.empty()) {
	    auto k = st.top();
	    res.push_back(k->val);
	    st.pop();
	    if (k->right != nullptr) {
		st.push(k->right);
	    }
	    if (k->left != nullptr) {
		st.push(k->left);
	    }
	}
	return res;
    }
};

int main(int argc, char* argv[])
{

    return 0;
}
