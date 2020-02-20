/**
 * 解法一：动态规划（二维数组）
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function (matrix) {
    if (!matrix || matrix.length == 0) return 0;
    let m = matrix.length;
    let n = matrix[0].length;
    let dp = Array.from({ length: m + 1 }, () => Array.from({ length: n + 1 }).fill(0));
    let maxEdge = 0;
    for (let i = 1; i <= m; i++)
        for (let j = 1; j <= n; j++) {
            if (matrix[i - 1][j - 1] == '1') {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1;
                maxEdge = Math.max(maxEdge, dp[i][j]);
            }
        }
    return maxEdge * maxEdge;
};
