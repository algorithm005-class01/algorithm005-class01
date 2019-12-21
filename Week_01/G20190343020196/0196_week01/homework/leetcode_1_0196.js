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
//暴力解法，引入登记表
var twoSum = function (nums, target) {
  const map = {}
  const len = nums.length
  for(let i=0;i<len; i++){
      const targetNum = target - nums[i];
      if(targetNum in map) return [map[targetNum], i]
      map[nums[i]] = i
  }  

};
// @lc code=end

// let arr = [2,7,11,15];
// let target = 9;
// let test = twoSum(arr, target);
// console.log(test);