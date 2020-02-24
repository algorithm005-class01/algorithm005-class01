/**
 * 其实就是找旋转点的问题
 * 旋转点前后两个都是升序的数组
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    let low = 0;
    let high = nums.length - 1;
    let mid;
    while (low < high) {
        mid = low + ((high - low) >> 1);
        // 旋转点在后面区间
        if (nums[mid] > nums[high]) low = mid + 1;
        // 旋转点在前面区间
        else high = mid;
    }
    return nums[low];
};
