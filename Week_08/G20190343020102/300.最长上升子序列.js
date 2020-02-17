/*
 * @lc app=leetcode.cn id=300 lang=javascript
 *
 * [300] 最长上升子序列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function (nums) {
  if(nums.length == 0 ) {
    return 0
  }
  let dp = new Array(nums.length)
  dp[0] = 1
  for (let i = 1; i < nums.length; i++) {
    let maxV = 0
    for(let j = 0; j < i; j++) {
      if(nums[i] > nums[j]) {
        maxV = Math.max(maxV,dp[j])
      }
    }
    dp[i] = maxV + 1
  }
  console.log(dp)
  return dp[nums.length - 1]
};
// @lc code=end

