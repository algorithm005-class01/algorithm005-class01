/*
 * @lc app=leetcode.cn id=121 lang=javascript
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function (prices) {
    let n = prices.length;
    if (n == 0) {
        return 0;
    }
    let dp = Array.from(new Array(n), () => new Array(2));
    for (let i = 0; i < n; i++) {
        if (i == 0) {
            dp[i][0] = 0;
            dp[i][1] = -prices[i];
            continue;
        }
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
    }
    return dp[n - 1][0];
};
// @lc code=end