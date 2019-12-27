# 学习笔记
## 本周作业
主要看[链接](https://github.com/algorithm005-class01/algorithm005-class01/issues/308)

##  Git的一些使用
- git reset HEAD , git add提交错误的话可以撤销所有的操作。
## c++的一些小语法
```c
struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
```
## 树的非递归遍历
树的非递归遍历通常采用栈结构，如leetcode94题所示
```c
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
```
可以这么定义一个Struct的构造函数。
## 本周小结
### 哈希表、映射、集合
一些使用hash表写的程序的心得，hash表可以有效的用空间换取时间，提高搜索的效率。
### 树、二叉树、二叉搜索树
学习了二叉搜索树的基本思想，二叉搜索树能够有效的提高树中节点的查找效率。
> 在二叉搜索树中使用中序遍历能够得到一个有序的数列
### 泛型递归、树的递归
写了几题典型的递归的例题，如斐波那契数递归实现，括号匹配，二叉树回溯等问题。对递归有了那么一点点感觉，还是要多多练习。

## 心得
这周主要配置好了VScode环境，之前自己用的编辑器一直都是ATOM，看了老师关于VScode的推荐之后发现确实是一个神器，使用起来非常便利，配置c环境花了不少时间，由于mac系统升级了的问题导致vscode中c代码不能调试。最后总算搜到了问题所在。然后主要学习了一下git的基本用法。在算法和程序方面对于递归有了些感觉(感觉这程序应该这样写，但是细细的想中间的每个步骤又想不清楚)。花在代码上的时间还是少了点需要更加努力💪