class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        // num1的长度可能大于m, 这里是确认数组尾部
        int p = m + n - 1;

        while (i >= 0 && j >= 0) {
            // 放置nums1和nums2数组当前位置较大的数
            nums1[p--] = nums1[i] < nums2[j] ? nums2[j--] : nums1[i--];
        }

        //处理剩余元素, 如果nums2已经循环完了, nums1剩余元素一定比nums2中的都小, 无需任何处理
        //如果nums1循环完了, 而num2没有循环完, 说明nums2中仍存在比nums1的第一个元素更小的元素, 需要放在nums1的首部
        for (int pp = j; pp >= 0; pp--) {
            nums1[pp] = nums2[pp];
        }

    }
}