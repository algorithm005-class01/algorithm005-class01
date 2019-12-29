/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {
    const map = {};
    
    for (let i = 0; i < nums.length; i++) {
        // Note that if only check the value of the other number
        // when the index is 0 it will act as the same as undefined
        // Thus we should use hasOwnProperty instead.
        // if (map[target - nums[i]]) {
        if (map.hasOwnProperty(target - nums[i])) {
            return [map[target - nums[i]], i];
        } else {
            map[nums[i]] = i;
        }
    }
    
    return [];
};