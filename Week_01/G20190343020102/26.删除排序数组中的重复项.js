/*
 * @lc app=leetcode.cn id=26 lang=javascript
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
  let pos = 1, i = 1
  while(i < nums.length) {
    if(nums[i] == nums[pos - 1]) {
      i++
    } else {
      nums[pos++] = nums[i++]
    }
  }
  nums.length = pos
};
// @lc code=end

