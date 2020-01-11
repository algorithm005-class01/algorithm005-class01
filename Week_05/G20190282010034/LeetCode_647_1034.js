/**
 * 题目：647.回文子串（https://leetcode-cn.com/problems/palindromic-substrings/）
 * 学号：1034（五期一班三组）
 * @param {string} s
 * @return {number}
 */
const countSubstrings = function (s) {

    let buildDPForCountSubstrings = (str) => {
        let n = str.length;
        let dp = Array.from({length: n}, () => (Array.from({length: n}, () => (false))));
        for (let j = 0; j < n; j++) {
            for (let i = 0; i <= j; i++) {
                if (i === j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = str.charAt(i) === str.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1]);
                }
            }
        }
        return dp;
    };
    if (s === null || s.length === 0) {
        return 0;
    }
    let res = 0;
    let dp = buildDPForCountSubstrings(s);
    for (let j = 0; j < dp.length; j++) {
        for (let i = 0; i <= j; i++) {
            if (dp[i][j]) res += 1;
        }
    }
    return res;
};
