//
//  LeetCode_226_0198.c
//  LeetCode-week-02
//
//  Created by cf on 2019/12/22.
//  Copyright © 2019 lcf. All rights reserved.
//

#include "LeetCode_226_0198.h"

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNodeinvertTree(struct TreeNoderoot){
    if (root == NULL) {
        return NULL;
    }
    struct TreeNode *right = invertTree(root->right);
    struct TreeNode *left = invertTree(root->left);
    root->left = right;
    root->right = left;
    return root;
}
