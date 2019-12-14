/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
  var j = 0;
  nums.forEach((item, i) => {
    if(i === 0) return;
    if(item !== nums[j]){
      nums[++j] = item;
    }
  });
  return j + 1;
};