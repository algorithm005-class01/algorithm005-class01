//
//  LeetCode_1_0198.c
//  LeetCode-week-01
//
//  Created by lcf on 2019/12/16.
//  Copyright © 2019 cf. All rights reserved.
//

#include "LeetCode_1_0198.h"
#include <malloc/_malloc.h>

int* twoSum(int* nums, int numsSize, int target, int* returnSize){

    int *sum = (int *)malloc(sizeof(int) * 2);
    *returnSize = 0;
    for(int i = 0; i < numsSize;++i) {
        for(int j = i+1;j<numsSize;++j) {
            if(nums[j] == target - nums[i]) {
                sum[0] = i;
                sum[1] = j;
                *returnSize = 2;
                return sum;
            }
        }
    }
    return sum;
}

