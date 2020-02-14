//给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。 
//
// 你需要返回给定数组中的重要翻转对的数量。 
//
// 示例 1: 
//
// 
//输入: [1,3,2,3,1]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: [2,4,3,5,1]
//输出: 3
// 
//
// 注意: 
//
// 
// 给定数组的长度不会超过50000。 
// 输入数组中的所有数字都在32位整数的表示范围内。 
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return 0;

        int mid = left + (right - left) / 2;

        int cnt = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        for (int i = left, j = mid + 1; i <= mid; i++) {
            while (j <= right && nums[i] / 2.0 > nums[j])
                j++;
            cnt += j - (mid + 1);
        }

//        Arrays.sort(nums, left, right + 1);
        merge(nums, left, mid, right);
        return cnt;
    }

    public void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }
        while (i <= mid)
            temp[k++] = array[i++];
        while (j <= right)
            temp[k++] = array[j++];

        for (int p = 0; p < temp.length; p++) {
            array[left + p] = temp[p];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
