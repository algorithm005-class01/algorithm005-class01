# 94.二叉树的中序遍历 
## 题目
[链接]()如下,用非递归的方法来返回一课树的中序遍历。
## 思路
这题是思路其实无非是递归和非递归，递归的树遍历很直观，非递归遍历树以前学过但是一时很难想起来，看了题解瞬间懂了。
## 题解
### 递归方法
官方题解采用java来做的，这里改写成了c++代码，递归的方法很简单直观，写了一个辅助函数来帮助实现和中序遍历，并把结果存储在res中返回。
```c
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        helper(root, res);
        return res;
    }
    //递归方法
    void helper(TreeNode*root , vector<int> &res){
        if(root==NULL)
            return;
        helper(root->left,res);
        res.push_back(root->val);
        helper(root->right,res);
    }
};
```
### 非递归解法
非递归解法一般基于栈来考虑，大致思想史每次都往左边遍历，把路径的元素都存储在栈里，如果到头了说明这时候需要弹出一个元素。弹出队头然后遍历这节点的右子树，这里要注意的是判断遍历完成的条件，curr!=NULL || !index.empty()，一开始我写成了&&导致怎么都过不了。
```c
class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode*> index;
        TreeNode* curr = root;
        while(curr!=NULL || !index.empty()){ //这个地方条件判断是或而不是与
            while(curr!=NULL){
                index.push(curr);
                curr = curr->left;
            }
            curr = index.top();
            index.pop();
            res.push_back(curr->val);
            curr = curr->right;
        }
        return res;
    }
    
};
```

