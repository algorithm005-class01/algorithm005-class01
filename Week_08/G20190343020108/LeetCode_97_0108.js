/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
    if (!s || !s.length) return 0;
    let n = s.length;
    let dp = Array.from({ length: n + 1 });
    dp[n] = 1;
    if (s[n - 1] === '0') dp[n - 1] = 0;
    else dp[n - 1] = 1;

    for (let i = n - 2; i >= 0; i--) {
        if (s[i] === '0') {
            dp[i] = 0;
            continue;
        }
        if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26)
            dp[i] = dp[i + 1] + dp[i + 2];
        else dp[i] = dp[i + 1];
    }

    return dp[0];
};
