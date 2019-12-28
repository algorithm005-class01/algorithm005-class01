class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) return mid;
            if (nums[lo] < nums[hi] && nums[lo] <= nums[mid] && nums[mid] <= nums[hi] ) {
                // 1, 2, 3, 4, 5, 6, 7
                if (target <= nums[mid]) hi = mid;
                else lo = mid + 1;
            }else {
                // 3,4,5,6,7,1,2
                if (nums[lo] <= nums[mid]) {
                    if (target <= nums[mid] && nums[lo] <= target) hi = mid;
                    else lo = mid + 1;
                } else {
                    // 5,6,7,1,2,3,4
                    if (nums[mid] < target && target <= nums[hi]) lo = mid + 1;
                    else hi = mid;
                }
            }
        }
        return -1;
    }
}
// 使用这个二分法实现，在leetcode上大部分提交结果是1ms
// 用遍历比较，大部分提交结果是0ms，所以应该是我这个2分写的太烂了，比较次数太多，cpu指令远大于遍历了