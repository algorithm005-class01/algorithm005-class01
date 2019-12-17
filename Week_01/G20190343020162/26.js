// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
/**
 * @param {number[]} nums
 * @return {number}
 */
//1.使用一个空数组
//2.老数组往新数组里放，如果有重复就不放
//3.新数组的前几个往老数组放


// 看提节后改： 发现数组是排序的
// 可以不用一个新数组
var removeDuplicates = function(nums) {
    var j = 0
    for(var i = 0; i< nums.length; i++) {
        if(nums[i]!==nums[j]) {
            j++ 
            nums[j] = nums[i]
        }
    }
    return j+1
};