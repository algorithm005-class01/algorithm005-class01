/*
 * @lc app=leetcode.cn id=11 lang=javascript
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (height) {
  let max = 0
  let curArea = 0
  for(let i = 0, j = height.length - 1; i < j; ) {
    curArea = (j - i) * Math.min(height[i],height[j])
    max = max < curArea ? curArea : max
    height [i] < height[j] ? i++ : j--
  }
  return max
};
// @lc code=end

