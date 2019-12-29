//
//  LeetCode_111_0198.c
//  LeetCode-week-02
//
//  Created by cf on 2019/12/22.
//  Copyright © 2019 lcf. All rights reserved.
//

#include "LeetCode_111_0198.h"
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

int minDepth(struct TreeNode* root){
    if(root == NULL){
        return 0;
    }

    int left_length = minDepth(root->left) + 1;
    int right_length = minDepth(root->right) + 1;
    
    if( root->left == NULL ){
        return right_length;
    }else if( root->right == NULL ){
        return left_length;
    }else if( left_length >= right_length ){
        return right_length;
    }else{
        return left_length;
    }
}
