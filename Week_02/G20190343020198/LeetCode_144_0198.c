//
//  LeetCode_144_0198.c
//  LeetCode-week-02
//
//  Created by cf on 2019/12/22.
//  Copyright © 2019 lcf. All rights reserved.
//

#include "LeetCode_144_0198.h"

#include <string.h>
#include <malloc/_malloc.h>

/*
 给定一个二叉树，返回它的中序 遍历。

 示例:

 输入: [1,null,2,3]
    1
     \
      2
     /
    3

 输出: [1,3,2]
 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};


/// 递归解法
void RecursiveInorder(struct TreeNode*root,int *returnSize,int *res)
{
    if (!root) {
        return;
    }
    res[(*returnSize)++] = root->val;
    RecursiveInorder(root->left,returnSize,res);
    RecursiveInorder(root->right,returnSize,res);
}


int CurTreeSize(struct TreeNode*root)
{
    if (!root)  {
        return 0;
    }
    return CurTreeSize(root->left) + CurTreeSize(root->right) + 1;
}

int* preorderTraversal(struct TreeNode* root, int* returnSize){

    int size= CurTreeSize(root);
    int *res= malloc(sizeof(int)*size);
    memset(res,0,size);
    *returnSize=0;
    RecursiveInorder(root,returnSize,res);
    return res;
}

int* twoPreorderTraversal(struct TreeNode* root, int* returnSize){
    
    
    int size = CurTreeSize(root);
    int p = -1,index = 0;
    if (!root) {
        *returnSize = 0;
        return NULL;
    }
    struct TreeNode** src = malloc(sizeof(struct TreeNode*) * size);
    int *res = malloc(sizeof(int) * size);
    
    while( root != NULL || p != -1)
    {
        
        while(root)
        {
        res[index++]=root->val;
         src[++p]=root;
         root=root->left;//一直往左走
        }

        if(p!=-1){
            root=src[p--];
            root=root->right;
        }
    }
    *returnSize =index;
    return res;
}
