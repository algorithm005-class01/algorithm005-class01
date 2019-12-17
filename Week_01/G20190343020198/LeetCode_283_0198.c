//
//  LeetCode_283_0198.c
//  LeetCode-week-01
//
//  Created by lcf on 2019/12/16.
//  Copyright © 2019 cf. All rights reserved.
//

#include "LeetCode_283_0198.h"
/*
 先把非零的移动到签名,同时记录非零数
 最后在添加 0
 */
void moveZeroes(int* nums, int numsSize){
    int j = 0;
    for (int i = 0; i < numsSize; i++) {
        if(nums[i] != 0) {
            nums[j] = nums[i];
            j++;
        }
    }
    for(int i = j; i < numsSize; i++) {
        nums[i] = 0;
    }
}

