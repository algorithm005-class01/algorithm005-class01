/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    if (!nums || nums.length == 0) return -1;
    let start = 0;
    let end = nums.length - 1;
    let mid = 0;
    while (start <= end) {
        mid = start + ((end - start) >> 1);
        // mid = Math.floor((start + end)/ 2);
        if (nums[mid] == target) return mid;
        if (nums[start] <= nums[mid]) {
            // 数组前半部分有序
            if (target >= nums[start] && target < nums[mid]) end = mid - 1;
            // target 在数组前半部分
            else start = mid + 1; // target 在数组后半部分
        } else {
            // 数组后半部分有序
            if (target <= nums[end] && target > nums[mid]) start = mid + 1;
            // target 在数组后半部分
            else end = mid - 1; // target 在数组前半部分
        }
    }
    return -1;
};
