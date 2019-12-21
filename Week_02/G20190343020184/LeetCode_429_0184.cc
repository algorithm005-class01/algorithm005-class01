#include <queue>
#include <vector>
using namespace std;

//简单的层序遍历
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
    vector<vector<int>> levelOrder(Node* root)
    {
	if (root == NULL) {
	    return {};
	}
	vector<vector<int>> res;
	queue<Node*> record;
	record.push(root);
	int count = 1;
	while (!record.empty()) {
	    vector<int> tmp_number;
	    while (count--) {
		//将该结点上的数值保存到 tmpnumber中
		Node* tmpNode = record.front();
		record.pop();
		tmp_number.push_back(tmpNode->val);
		;

		//将该结点的孩子结点放到队列中
		for (int i = 0; i < tmpNode->children.size(); ++i) {
		    if (tmpNode->children[i] != NULL) {
			record.push(tmpNode->children[i]);
		    }
		}
	    }
	    count = record.size();
	    res.push_back(tmp_number);
	    tmp_number.clear();
	}
	return res;
    }
};
