/**
 * https://leetcode-cn.com/problems/majority-element/
 * 
 * @param {number[]} nums
 * @return {number}
 */
var majorityElement = function(nums) {
  var sum = 0;
  var key;
  
  for (n of nums){
    sum ? (key === n ? sum++ : sum--) : (key = n, sum++);
  }

  return key;
};