//
//  LeetCode_88_0198.c
//  LeetCode-week-01
//
//  Created by cf on 2019/12/15.
//  Copyright © 2019 cf. All rights reserved.
//

#include "LeetCode_88_0198.h"

// 先合并,在排序
void merge(int* nums1, int nums1Size, int m, int* nums2, int nums2Size, int n) {
    if ((m + n) > nums1Size) {
        return;
    }
    if ((nums2Size > nums1Size)) {
        return;
    }
    for (int i = 0; i < n; ++i) {
        nums1[m + i] = nums2[i];
    }
    for (int i= 0; i < nums1Size - 1; ++i) {
        for (int j = i+1; j < nums1Size; ++j) {
            if (nums1[i] >= nums1[j]) {
                int tmp = nums1[i];
                nums1[i] = nums1[j];
                nums1[j] = tmp;
            }
        }
    }
}
