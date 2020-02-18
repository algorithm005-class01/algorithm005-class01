//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 题目：51.N皇后（https://leetcode-cn.com/problems/n-queens/）
 * 学号：1034（五期一班三组）
 * @param {number} n
 * @return {string[][]}
 */
const solveNQueens = function (n) {
    let res = [], cols = new Set(), pie = new Set(), na = new Set(), dfs = (n, row, curState) => {
        if (row >= n) {
            res.push(curState);
            return;
        }
        for (let c = 0; c < n; c++) {
            if (cols.has(c) || pie.has(row + c) || na.has(row - c)) continue;
            cols.add(c);
            pie.add(row + c);
            na.add(row - c);
            dfs(n, row + 1, curState.concat([c]));
            cols.delete(c);
            pie.delete(row + c);
            na.delete(row - c);
        }
    }, afterResult = (n) => {
        let after = [], board = res.reduce((all, a) => {
            for (let r of a) all.push(''.padEnd(r, '.') + 'Q' + ''.padEnd(n - r - 1, '.'));
            return all;
        }, []);
        for (let i = 0; i < board.length; i += n) after.push(board.slice(i, i + n));
        return after;
    };
    dfs(n, 0, []);
    return afterResult(n);
};
//leetcode submit region end(Prohibit modification and deletion)