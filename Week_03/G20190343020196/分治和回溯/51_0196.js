/*
 * @lc app=leetcode.cn id=51 lang=javascript
 *
 * [51] N皇后
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function (n) {
    let result = new Array(n);
    let results = [];

    // 回溯排除
    // 判断 row 行 column 列放置是否合适
    let dfs = (row, column) => {
        let leftColumn = column - 1;
        let rightColumn = column + 1;
        // 逐上判断每一行是否能放棋子
        for (let i = row - 1; i >= 0; i--) {
            // // 第i行第column列是否有棋子【上一行同一列不能有棋子】
            if (result[i] == column) {
                return false;
            }

            // 当左列存在 && 考虑左上对角线【递减斜向上】 第i行第leftColumn列是否有棋子
            if (leftColumn >= 0 && result[i] == leftColumn) {
                return false;
            }
            // 当右列存在 && 考虑右上对角线【递减斜向上】 第i行第rightColumn列是否有棋子
            if (rightColumn < n && result[i] == rightColumn) {
                return false;
            }
            leftColumn--;
            rightColumn++;
        }
        return true;
    }

    // 开始搜索
    let Nqueens = (row) => {
        // 排除到最后一行，即当前所有行均排查过，
        // 意味着找到了一个解
        if (row == n) {
            results.push(result.map(c => '.'.repeat(c) + 'Q' + '.'.repeat(n - 1 - c)));
            return;
        }
        for (let j = 0; j < n; j++) {
            if (dfs(row, j)) {
                result[row] = j;
                Nqueens(row + 1)
            }
        }
    }
    Nqueens(0);
    return results;

};
// @lc code=end