/*
 * @lc app=leetcode.cn id=283 lang=javascript
 *
 * [283] 移动零
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function (nums) {
  let temp
  for (let i = 0, j = 0; j < nums.length; j++) {
    if(nums [j] != 0) {
      temp = nums[i]
      nums[i] = nums[j]
      nums[j] = temp
      i++
    }
  }
};
// @lc code=end

//1 遇到0就删除 再往后补一个
//2 调换位置