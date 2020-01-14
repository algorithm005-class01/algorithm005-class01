/**
 * 题目：64.最小路径和（https://leetcode-cn.com/problems/minimum-path-sum/）
 * 学号：1034（五期一班三组）
 * @param {number[][]} grid
 * @return {number}
 */
const minPathSum = function (grid) {
    let dp = Array.from({length: grid.length}, () => (
        Array.from({length: grid[0].length}, () => (0)))
    );
    for (let i = grid.length - 1; i >= 0; i--) {
        for (let j = grid[0].length - 1; j >= 0; j--) {
            if (i === grid.length - 1 && j !== grid[0].length - 1) {
                dp[i][j] = grid[i][j] + dp[i][j + 1];
            } else if (j === grid[0].length - 1 && i !== grid.length - 1) {
                dp[i][j] = grid[i][j] + dp[i + 1][j];
            } else if (j !== grid[0].length - 1 && i !== grid.length - 1) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            } else {
                dp[i][j] = grid[i][j];
            }
        }
    }
    return dp[0][0];
};
