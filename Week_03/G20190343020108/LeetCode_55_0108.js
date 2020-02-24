/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function(nums) {
    if (!nums || !nums.length) return false;
    let reachable = nums.length - 1; // 从后往前遍历
    for (let i = nums.length - 1; i >= 0; i--) {
        if (nums[i] + i >= reachable) reachable = i;
    }
    return reachable == 0;
};
