/*
 * @lc app=leetcode.cn id=33 lang=javascript
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
  let l = 0, r = nums.length - 1 ,mid
  while(l <= r) {
    mid = (l + r) >> 1
    if(nums[mid] == target) {
      return mid
    }
    if(nums[l] <= nums[mid]) {
        if(target >= nums[l] && target < nums[mid]){
          r = mid - 1
        } else {
          l = mid + 1
        }
    } else {
      if(target <= nums[r] && target > nums[mid]) {
        l = mid + 1
      } else {
        r = mid - 1
      }
    }
  }    
  return -1
};
// @lc code=end

