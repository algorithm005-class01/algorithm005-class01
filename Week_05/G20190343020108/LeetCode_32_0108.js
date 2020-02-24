/**
 * 解法一：动态规划
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
    if (!s || s.length < 2) return 0;
    let n = s.length;
    let res = 0;
    let dp = Array.from({ length: n }).fill(0);
    for (let i = 1; i < n; i++) {
        if (s[i] === ')') {
            if (s[i - 1] === '(') dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
            else {
                let j = i - dp[i - 1];
                if (j > 0 && s[j - 1] === '(') {
                    dp[i] = dp[i - 1] + (j >= 2 ? dp[j - 2] : 0) + 2;
                }
            }
            res = Math.max(res, dp[i]);
        }
    }
    return res;
};
