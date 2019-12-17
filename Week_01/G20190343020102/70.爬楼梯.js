/*
 * @lc app=leetcode.cn id=70 lang=javascript
 *
 * [70] 爬楼梯
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function (n) {
  if( n < 3) {
    return n
  }
  let  a = 1, b = 2,c = 0;
  for(let i = 3; i <= n; i++) {
    c = a + b
    a = b
    b = c
  }
  return c
};
// @lc code=end

