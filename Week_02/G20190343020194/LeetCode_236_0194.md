# 二叉树的最近公共祖先
## 题目
给两个节点招最精的公共祖先节点
## 思路
-  倒叙记录下节点所有的祖先节点，一一对比直到出现不同则这个节点上一个就是他们最近的公共节点。
- 重建树结构，把每个指针改成双向结构
## 题解
### 记录下祖先节点
采用回溯的方法记录下子节点所有的祖先节点，然后一一对比祖先节点,这个方法的时间和空间效率似乎都不高。但是按照我的分析应该都是O(n)的。
```c
class Solution {
public:
    int flag = 0;
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        vector<TreeNode*> resp;
        vector<TreeNode*> resq;
        findzuxian(resp, root, p);
        flag = 0;
        findzuxian(resq, root, q);
        //已经查找好p,q的所有祖先节点，查找第一个不同的节点
        int i ;
        for (i = 0 ; i<resp.size()&&i<resq.size(); i++) {
            if(resp[i]!=resq[i])
                return resp[i-1];
        }
        if (resp.size()>resq.size()) {
            return resp[i-1];
        }
        else{
            return resq[i-1];
        }
    }
    // 查找祖先, 并在vector res中存储下来
    void findzuxian(vector<TreeNode*> &res, TreeNode* root, TreeNode* son){
        if (root==NULL || flag == 1)
            return ;
        res.push_back(root);
        if (root!=son) {
            findzuxian(res,root->left,son);
            if(flag==1)
                return;
            findzuxian(res,root->right,son);
            if(flag==1)
                return;
            res.pop_back();
        }
        else {
            flag = 1;
        }
    }
};
```
