//
//  LeetCode_66_0198.c
//  LeetCode-week-01
//
//  Created by lcf on 2019/12/16.
//  Copyright © 2019 cf. All rights reserved.
//

#include "LeetCode_66_0198.h"
#include <malloc/_malloc.h>

int* plusOne(int* digits, int digitsSize, int* returnSize){

    for (int i = digitsSize - 1; i >= 0; --i) {
        if (digits[i] == 9) {
            digits[i] = 0;
        }
        else {
            digits[i] += 1;
            *returnSize = digitsSize;
            return digits;
        }
    }
    int *num = (int*)malloc(sizeof(int) * (digitsSize + 1));
    num[0] = 1;
    for (int i = 1; i <= digitsSize; ++i) {
        num[i] = 0;
    }
    *returnSize = digitsSize + 1;
    return num;
}
