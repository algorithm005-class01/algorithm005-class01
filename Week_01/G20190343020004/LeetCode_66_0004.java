package com.zyh.test;

public class LeetCode_66_0004 {

    public int[] plusOne(int[] digits) {
        if (digits != null && digits.length > 0) {
            int index = digits.length - 1;
            while (index >= 0) {
                int result = digits[index] + 1;
                if (result < 10) {
                    digits[index] = result;
                    break;
                } else {
                    digits[index] = 0;
                    index--;
                }
            }
            if (index < 0) {
                digits = new int[digits.length + 1];
                digits[0] = 1;
            }
        }
        return digits;
    }
}
