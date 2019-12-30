/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let left = 0;
    let right = nums.length - 1;
    
    while (left < right) {
        let mid = Math.floor((left + right) / 2);
        // only nums[0] < nums[mid] will miss some cases
        // [-1, 3] target=3
        if (nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0])) {
            left = mid + 1;
        // the first condition can be simplified
        // target > nums[mid] && target < nums[0] will also work
        } else if (nums[0] > nums[mid] && target > nums[mid] && target < nums[0]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    
    // don't forget to check if nums[left] === target
    return left === right && nums[left] === target ? left : -1;
};
