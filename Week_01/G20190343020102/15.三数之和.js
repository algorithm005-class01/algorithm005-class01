/*
 * @lc app=leetcode.cn id=15 lang=javascript
 *
 * [15] 三数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
  let res = []
  nums.sort( (a,b) => { return a - b})
  // console.log(nums)
  for(let i = 0; i < nums.length; i++) {
    let target = nums[i]
    if(target > 0) {
      break
    }
    if(i > 0 && nums[i] == nums[i - 1]) {
      continue
    }
    let j = i + 1, k = nums.length - 1
    while ( j < k) {
      let sum = target + nums[j] + nums[k]
      // console.log(target, nums[j], nums[k])
      if(sum > 0) {
        while(j < k && nums[k] == nums[--k]);
      } else if(sum < 0) {
        while(j < k && nums[j] == nums[ ++j]);
      } else {
        //加入数据
        res.push([target,nums[j],[nums[k]]])
        while(j < k && nums[j] == nums[++j]);
        while(j < k && nums[k] == nums[--k]);
      }
    }
  }  
  return res
}

// @lc code=end

