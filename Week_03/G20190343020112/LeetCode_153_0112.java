class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        if (nums[lo] < nums[hi]) return nums[lo];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid] < nums[mid - 1]) return nums[mid];
            if (nums[lo] > nums[mid]) hi = mid - 1;
            else lo = mid + 1;
        }
        return (nums[0] < nums[nums.length - 1]) ? nums[0] : nums[nums.length - 1];
    }
}


//0ms, 遍历
// class Solution {
//     public int findMin(int[] nums) {
//         for (int i = 1; i < nums.length - 1; i++) {
//             if (nums[i - 1] > nums[i] && nums[i] < nums[i + 1]) return nums[i];
//         }
//         return (nums[0] < nums[nums.length - 1]) ? nums[0] : nums[nums.length - 1];
//     }
// }