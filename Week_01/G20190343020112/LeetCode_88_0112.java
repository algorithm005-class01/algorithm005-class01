class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        int[] nums = new int[length];
        int i = 0, j = 0, k = 0;


        while (k < length) {
            if (i < m && j < n) {
                if (nums1[i] < nums2[j]) {
                    nums[k++] = nums1[i++];
                } else if (j < n) {
                    nums[k++] = nums2[j++];
                }
            } else if (i < m) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }

        System.arraycopy(nums, 0, nums1, 0, length);

    }
}