package com.zyh.test.leetcode;

public class LeetCode_190_0004 {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) + (n & 1);
            n = n >> 1;
        }
        return result;
    }
}
