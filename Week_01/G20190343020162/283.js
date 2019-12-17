// https://leetcode-cn.com/problems/move-zeroes/

/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */

// 定义一个j表示非0的位置
var moveZeroes = function(nums) {
    let j = 0
    for(let i = 0; i<nums.length; i++) {
        if(nums[i]!=0) {
            nums[j] = nums[i]
            if(j != i) {
                nums[i] = 0
            }
            j++
        }
    }
};