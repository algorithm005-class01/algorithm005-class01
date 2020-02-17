class Solution {
public:
    void pre(Node* root,vector<int>& t)
    {
        if(!root)
            return;
        t.push_back(root->val);
        for(auto p:root->children)
            pre(p,t);
    }
    vector<int> preorder(Node* root) {
        vector<int> result;
        pre(root,result);
        return result;
        
    }
};