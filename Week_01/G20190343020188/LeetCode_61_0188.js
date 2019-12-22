/**
 * https://leetcode-cn.com/problems/plus-one/submissions/
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
  var length = digits.length;

  for(var i = length - 1; i >= 0; i--) {
    digits[i]++;
    digits[i] %= 10;
    if(digits[i] !== 0) return digits;
  }

  digits = new Array(length + 1).fill(0);
  digits[0] = 1;

  return digits;
};