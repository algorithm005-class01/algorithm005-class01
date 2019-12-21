package main.leetcode_solutions.linkedlist;

/**
 * @author wenzhuang
 * @date 2019-12-15
 */
public class T88_MergeSortedArray {
    /**
     * 二路归并：从后向前归并
     * T(n)=O(m+n), S(n)=O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1, i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0){
            if (nums1[i] >= nums2[j]){
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
        while (j >= 0){
            nums1[index--] = nums2[j--];
        }
    }
}
