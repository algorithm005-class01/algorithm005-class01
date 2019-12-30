/*
 * @lc app=leetcode.cn id=169 lang=javascript
 *
 * [169] 多数元素
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function (nums) {

  //1.hash
  // let ans = {} , num
  // for (let i = 0; i < nums.length; i++) {
  //   ans[nums[i]] ? ans[nums[i]] ++ : ans[nums[i]] = 1
  // }
  // for(let i in ans) {
  //   if(ans[i] > (nums.length >> 1)) {
  //     num = i
  //     break
  //   }
  // }
  // return num


  //2.分治算法
  // return divideAndMerge(nums,0, nums.length - 1)

  //3.投票
  let count = target = 0
  for(let i = 0; i < nums.length; i++) {
    if(count === 0) {
      target = nums[i]
    } 
    target == nums[i] ? count++ : count--
  }
  return target
}; 
//2.分治
// let divideAndMerge = (nums, start, end) => {
//   if(start == end) {
//     return nums[start]
//   }
//   let left = divideAndMerge(nums, start, start + end >> 1)
//   let right = divideAndMerge(nums, (start + end >> 1) + 1, end)
//   if(left == right) {
//     return left
//   }
//   return maxCount(nums, start , end, [left,right])
// }
// let maxCount = (nums, start, end, arr) => {
//   let max = 0, maxVal = 0, temp
//   for(let i = 0; i < 2; i++) {
//     temp = 0
//     for(let j = start; j <= end; j++) {
//       if(arr[i] == nums[j]) {
//         temp ++
//       }
//     }
//     if(max < temp) {
//       max = temp
//       maxVal = arr[i]
//     }
//   }
//   return maxVal
// }
// @lc code=end

