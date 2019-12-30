/*
 * @lc app=leetcode.cn id=122 lang=javascript
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
  let val = 0
  for(let i = 0; i < prices.length - 1; i++) {
    if(prices[i] < prices[i + 1]) {
      val += prices[i + 1] - prices[i]
    }
  }
  return val
};
// @lc code=end

