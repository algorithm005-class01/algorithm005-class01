// 解法：动态规划 由下至上
var minPathSum = function (grid) {
    const m = grid.length,
        n = grid[0].length;
    for (let i = m - 1; i >= 0; i--) {
        for (let j = n - 1; j >= 0; j--) {
            if (i + 1 < m && j + 1 < n) {
                grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
            } else if (i + 1 < m) {
                grid[i][j] += grid[i + 1][j];
            } else if (j + 1 < n) {
                grid[i][j] += grid[i][j + 1];
            }
        }
    }
    return grid[0][0];
};