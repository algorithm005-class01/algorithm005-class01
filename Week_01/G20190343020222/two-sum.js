/*
 * @lc app=leetcode id=1 lang=javascript
 *
 * [1] Two Sum
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

var twoSum = function(nums, target) {
    const pair = new Map();
    for (let i = 0; i < nums.length; i++) {
        if (pair.has(target - nums[i])) {
            return [i, pair.get(target - nums[i])];
        }
        
        pair.set(nums[i], i);
    }
    return [];
};
// @lc code=end
