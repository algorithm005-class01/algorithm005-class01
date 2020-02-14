class Solution {
    public int reversePairs(int[] nums) {
        return mergerSort(nums, 0, nums.length - 1);
    }

    private int mergerSort(int[] nums, int start, int end) {
        int count = 0;
        if (start < end) {
            int mid = ((start + end) >> 1);
            count = mergerSort(nums, start, mid) + mergerSort(nums, mid + 1, end);
            int j = mid + 1;
            for (int i = start; i <= mid; i++) {
                while (j <= end && ((nums[i] >> 1) + (nums[i] & 1)) > nums[j]) j++;
                count += (j - (mid + 1));
            }
            merge(nums, start, mid, end);
        }
        return count;
    }

    private void merge(int[]nums, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            tmp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= end) {
            tmp[k++] = nums[j++];
        }
        System.arraycopy(tmp, 0, nums, start, tmp.length);
    }
}
