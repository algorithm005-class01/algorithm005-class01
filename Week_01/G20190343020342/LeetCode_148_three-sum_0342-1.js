// 方法一、暴力求解，直接超时
// 时间复杂度：O(n^3)
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    var result = [];
    var map = new Map();
    var len = nums.length
    for (var i = 0; i < len - 2; i++) {
        for (var j = i + 1; j < len - 1; j++) {
            for (var k = j + 1; k < len; k++) {
                if (nums[i] + nums[j] + nums[k] === 0) {
                    var tempArr = [nums[i], nums[j], nums[k]].sort();
                    if (!map.get(String(tempArr))) {
                        map.set(String(tempArr), true);
                        result.push(tempArr);
                    }
                }
            }
        }
    }
    return result;
};