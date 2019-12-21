class Solution {
public:
    vector<int> preorderTraversal(TreeNode* root) {
        stack <TreeNode*> S;
        vector <int> res;
        TreeNode* rt = root;
        while (rt || S.size()) {
            while (rt) {
                res.push_back(rt->val);
                S.push(rt->right);
                rt = rt->left;
            }
            rt = S.top();
            S.pop();
        }
        return res;
    }
};