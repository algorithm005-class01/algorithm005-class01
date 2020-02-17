package com.zyh.test.leetcode;

public class LeetCode_541_0004 {

    public String reverseStr(String s, int k) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] arr = s.toCharArray();
        int length = arr.length;
        int i = 0;
        while (i < length) {
            int j = Math.min(i + k - 1, length - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }

    private void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}
