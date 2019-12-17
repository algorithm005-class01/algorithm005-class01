/*
 * @lc app=leetcode.cn id=1 lang=javascript
 *
 * [1] 两数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    let hash = {}, ans = []
    for (let i = 0; i < nums.length; i++) {
      hash[nums[i]] =  i
    }
    for(let i = 0; i < nums.length; i++) {
      if(hash[target - nums[i]] && hash[target - nums[i]] != i) {
        ans = [i , hash[target - nums[i]]]
        break
      }
    }
    return ans
};
// @lc code=end

