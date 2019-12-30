/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */

 // 看题解的
var search = function(nums, target) {
    var low = 0;
    var high = nums.length - 1;
    while(low < high){
        var mid = (low+high)>>1;
        if( (nums[0] > nums[mid]) ^ (target > nums[mid]) ^ (target < nums[0]) ) {
            low = mid+1;
        }
        else{
            high = mid;
        }
    }
    return low == high && nums[low] == target ? low : -1;
};