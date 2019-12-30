/*
 * @lc app=leetcode.cn id=55 lang=javascript
 *
 * [55] 跳跃游戏
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    let ans = 0
    for(let i = nums.length - 1; i >= 0; i--) {
      if(i + nums[i] >= ans) {
        ans = i
      }
    }
    return ans == 0
};
// @lc code=end

