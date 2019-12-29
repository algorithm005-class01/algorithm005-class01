//
//  LeetCode_189_0198.c
//  LeetCode-week-01
//
//  Created by cf on 2019/12/15.
//  Copyright © 2019 cf. All rights reserved.
//

#include "LeetCode_189_0198.h"

void reverse(int*nums, int start, int end);

void rotate(int* nums, int numsSize, int k) {
    k %= numsSize;// 例如 k = 3, 可能出现 k 大于 数组长度,所以做一步取余操作
    // 首先把整个数组反转,例如 1234567,反转后7654321
    reverse(nums, 0, numsSize - 1);
    // 反转数组前 k 个数据, 例如 7654321,反转后5674321
    reverse(nums, 0, k - 1);
    // 反转数组后 numSize - 1 - k个 数据: 例如 5674321,反转后5671234
    reverse(nums, k, numsSize - 1);
}

// 反转
void reverse(int*nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}

// 第二种解法
void rotateTwo(int* nums, int numsSize, int k) {
    int a[numsSize];
    // 新建数组, 通过 (i+ k) % numsSize,获取反转结果
    for (int i = 0; i < numsSize; i++) {
        a[(i + k) % numsSize] = nums[i];
    }
    // 更改原数组
    for (int i = 0; i < numsSize; i++) {
        nums[i] = a[i];
    }
}
