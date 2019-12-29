//
//  LeetCode_104_0198.c
//  LeetCode-week-02
//
//  Created by cf on 2019/12/22.
//  Copyright © 2019 lcf. All rights reserved.
//

#include "LeetCode_104_0198.h"


struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};



int maxDepth(struct TreeNode *root){
    if(root == NULL){
        return 0;
    }

    int left_length = maxDepth(root->left) + 1;
    int right_length = maxDepth(root->right) + 1;
    
    if( left_length >= right_length){
        return left_length;
    }else{
        return right_length;
    }
}

