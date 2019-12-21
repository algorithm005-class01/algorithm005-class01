s/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    let lastAvailabelIndex = 0;
    for (let p = 0; p < nums.length; p++) {
        if (nums[p] !== 0) {
            if (lastAvailabelIndex !== p) {
                nums[lastAvailabelIndex] = nums[p];
                nums[p] = 0;
            }
            lastAvailabelIndex++;
        }
    }

    return nums;
};
// @lc code=end