/*
 * @lc app=leetcode.cn id=189 lang=javascript
 *
 * [189] 旋转数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    k %= nums.length
    let count = 0
    for(let i = 0; count < nums.length; i++) {
      let cur = i, curVal = nums[i], temp, next
      do {
        next = (cur + k) % nums.length
        temp = nums[next]
        nums[next] = curVal
        curVal = temp
        cur = next
        count ++ 
      } while (cur != i);
    }
};
// @lc code=end

