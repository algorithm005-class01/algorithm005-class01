/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        vector<vector<int>> res;
        if(root == NULL)
            return res;
        queue<Node*> q;
        q.push(root);
        while(!q.empty()) {
            vector<int> tmp;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node* curr = q.front();
                q.pop();
                tmp.push_back(curr->val);
                for(Node* children : curr->children) {
                    q.push(children);
                }    
            }
            res.push_back(tmp);
        }
        return res;
    }
};