//
//  LeetCode_26_0198.c
//  LeetCode-week-01
//
//  Created by cf on 2019/12/15.
//  Copyright © 2019 cf. All rights reserved.
//

#include "LeetCode_26_0198.h"

// 双指针法
int removeDuplicates(int* nums, int numsSize) {
    // 如果数组长度不够,返回0
    if (numsSize == 0) {
        return 0;
    }
    // 慢指针 i, 快指针 j
    int i = 0,j;
    // 如果 nums[i] == nums[j], 就增加 j 跳过重复项.
    // 当 nums[i] != nums[j] 时.把 nums[j] 的值赋值到 nums[i + 1]上
    for (j=1; j < numsSize; ++j ) {
        if (nums[j] != nums[i]) {
            ++i;
            nums[i] = nums[j];
        }
    }
    return i+1;
}

