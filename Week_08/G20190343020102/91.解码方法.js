/*
 * @lc app=leetcode.cn id=91 lang=javascript
 *
 * [91] 解码方法
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function (s) {
  if (s.length === 0) {
    return 0
  }
  let dp = new Array(s.length)
  dp[0] = +s[0] > 0 ? 1 : 0
  for (let i = 1; i < s.length; i++) {
    let num = +(s[i - 1] + s[i])
    dp[i] = +s[i] === 0 ? 0 : dp[i - 1]
    if (num < 27 && num > 0 && s[i - 1] !== '0') {
      dp[i] += i - 2 >= 0 ? dp[i - 2] : 1
    }
  }
  return dp[s.length - 1]
};
// @lc code=end

