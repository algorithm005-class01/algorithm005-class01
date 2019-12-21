class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        stack <TreeNode*> S;
        vector <int> res;
        TreeNode* rt = root;
        while (rt || S.size()) {
            while (rt) {
                S.push(rt);
                rt = rt->left;
            }
            rt = S.top();
            S.pop();
            res.push_back(rt->val);
            rt = rt->right;
        }
        return res;
    }
};