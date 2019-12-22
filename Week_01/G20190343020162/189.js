// https://leetcode-cn.com/problems/rotate-array/
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */

// 1. 建立一个新数组
// 2. 老数组的每个元素push进这个数组，如果数组的(i+k)-length<=0，直接放(i+k)，否则放在(i+k)-length

var rotate = function(nums, k) {
    var arrLength = nums.length
    if(k<=arrLength) {
        nums = doRotate(nums, k, arrLength)
    } else {
        k = k-arrLength 
        nums = doRotate(nums, k, arrLength)
    }
};

function doRotate(nums, k, arrLength){
    var newArr = [...nums]
    for(var i=0; i<arrLength; i++) {
        if((i+k)-arrLength<0) {
            nums[i+k] = newArr[i]
        } else {
            nums[(i+k)-arrLength] = newArr[i]
        }
    }   
    return newArr
}