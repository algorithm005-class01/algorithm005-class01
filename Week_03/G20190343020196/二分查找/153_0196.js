/*
 * @lc app=leetcode.cn id=153 lang=javascript
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
//两边夹逼直到low == high ，剩下的一个元素即为无序点
var findMin = function (nums) {
    var low = 0;
    var high = nums.length - 1;
    while (low < high) {
        var mid = (low + high) >> 1;
        if (nums[mid] > nums[high]) {
            low = mid + 1;
        } else {
            high = mid
        }
    }
    return nums[low];

};
// @lc code=end