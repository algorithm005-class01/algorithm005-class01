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
    vector<int> postorder(Node* root) {
        vector<int> res;
        if (!root)
            return res;
        stack<Node*> st;
        st.push(root);
        while(st.size() > 0) {
            Node* curr = st.top();
            st.pop();
            res.push_back(curr->val);
            for (Node* children: curr->children) {
                st.push(children);
            }   
        }
        reverse(res.begin(), res.end());
        return res;
    }
};