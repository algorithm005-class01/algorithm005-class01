#include <vector>
using namespace std;

class Node {
public:
    int val;
    vector<Node*> children;
    Node() {}
    Node(int _val, vector<Node*> _children)
    {
	val = _val;
	children = _children;
    }
};

class Solution {
public:
    vector<int> res;

    vector<int> preorder(Node* root)
    {
	if (root != NULL) {
	    res.push_back(root->val);
	    for (auto n : root->children)
		preorder(n);
	}
	return res;
    }
};
