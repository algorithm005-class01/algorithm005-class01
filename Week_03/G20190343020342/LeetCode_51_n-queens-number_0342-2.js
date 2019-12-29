// 解法二：对角线约束
// 同一对角线上的两个坐标，它们的横坐标之差等于纵坐标之差


/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function (n) {
    const result = [];
    const dfs = ( subResult = [], row = 0) => {
        if (row === n) {
            result.push(subResult.map(c => '.'.repeat(c) + 'Q' + '.'.repeat(n - c - 1)));
            return;
        }
        for (let col = 0; col < n; col++) {
            if (!subResult.some((j, k) => j === col || j - col === row - k || j - col === k - row)) {
                subResult.push(col);
                dfs( subResult, row + 1);
                subResult.pop();
            }
        }
    }
    dfs();
    return result;
};