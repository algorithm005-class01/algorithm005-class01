package week07;

public class LeetCode_493 {
    public int reversePairs(int[] nums) {
        return mergerSort(nums, 0, nums.length - 1);
    }

    private int mergerSort(int[] nums, int left, int right) {
        int count = 0;
        if (right <= left) return count;

        int mid = (left + right) >> 1;

        count = mergerSort(nums, left, mid) + mergerSort(nums, mid + 1, right);
        int j = mid + 1;

        //多一次类似与合并的统计， 统计2倍的数量
        for (int i = left; i <= mid; i++) {
            while (j <= right && ((nums[i] >> 1) + (nums[i] & 1)) > nums[j]) j++;
            count += (j - (mid + 1));
        }
        merge(nums, left, mid, right);

        return count;
    }

    private void merge(int[]nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            tmp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }

        while (i <= mid)    tmp[k++] = nums[i++];
        while (j <= right)  tmp[k++] = nums[j++];


        for (int p = 0; p < tmp.length; p++) {
            nums[left + p] = tmp[p];
        }
        // System.arraycopy(tmp, 0, nums, left, tmp.length);
    }
}
