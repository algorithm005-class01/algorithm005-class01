#include <iostream>
#include <stack>
#include <vector>
using namespace std;

//没啥可说的，就是遍历
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
    vector<int> postorder(Node* root)
    {
	vector<int> res;
	if (!root)
	    return res;
	stack<Node*> st;
	st.push(root);
	while (!st.empty()) {
	    Node* node = st.top();
	    st.pop();
	    if (!node)
		continue;
	    for (Node* child : node->children) {
		st.push(child);
	    }
	    res.push_back(node->val);
	}
	reverse(res.begin(), res.end());
	return res;
    }
};
