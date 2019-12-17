/*
 * @lc app=leetcode.cn id=66 lang=javascript
 *
 * [66] 加一
 */

// @lc code=start
/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
  //解法1
  // let carry = 0
  // let i = digits.length - 1
  // let temp
  // digits[i] += 1
  // while (i > 0) {
  //   digits[i] += carry
  //   temp = digits[i] 
  //   digits[i--] = temp % 10
  //   carry = parseInt(temp / 10) 
  // }
  // if(digits[0] + carry > 9) {
  //   digits[0] =(digits[0] + carry) % 10
  //   digits.unshift(1)
  // } else {
  //   digits[0] += carry
  // }
  // return digits

  //解法2 
  // return提高了很多 runtime 
  const len = digits.length;
  for(let i = len - 1; i >= 0; i--) {
      digits[i]++;
      digits[i] %= 10;
      if(digits[i]!=0)
          return digits;
  }
  digits.unshift(1)
  return digits;
};
// @lc code=end

