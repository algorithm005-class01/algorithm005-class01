package week_01.commit;

import java.util.Collections;
import java.util.List;

// 合并两个有序数组
// https://leetcode-cn.com/problems/merge-sorted-array/
public class Solution_88 {
    void merge(int nums1[], int m, int nums2[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        while (j >= 0)
            nums1[k--] = nums2[j--];
    }
}
