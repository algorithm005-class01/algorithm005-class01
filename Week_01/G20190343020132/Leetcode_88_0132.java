package org.azai.train.Week01;

public class Leetcode_88_0132 {
    //三指针 指针index指向元素应该放的位置，初始值再nums1的末尾  其他两个指针分别枚举nums1，nums2，将大的值放到index
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n -1;
        int i = m - 1;
        int j = n - 1;
        while (true) {
            if (j == -1) {
                return;
            }
            if (i == -1) {
                for (;j >=0 ;j --) {
                    nums1[j] = nums2[j];
                }
                return;
            }
            nums1[index--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
    }
}
