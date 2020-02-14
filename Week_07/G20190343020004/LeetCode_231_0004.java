package com.zyh.test.leetcode;

public class LeetCode_231_0004 {

    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        return ((long) n & ((long) n - 1)) == 0;
    }
}
