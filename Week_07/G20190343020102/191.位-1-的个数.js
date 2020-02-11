/*
 * @lc app=leetcode.cn id=191 lang=javascript
 *
 * [191] 位1的个数
 */

// @lc code=start
/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    // x = x & (x - 1) //清零最低位的 1
    // x = x & -x //得到最低位的1
    // x & ~x  //0
    let count = 0
    while(n != 0) {
      count++
      n = (n & (n - 1))
    }
    return count
};
// @lc code=end

101
100