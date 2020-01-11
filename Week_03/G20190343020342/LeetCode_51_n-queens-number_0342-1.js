// 递归回溯
// 从每一行开始，向上一行递归查询每一列是否符合皇后的摆放位置
// 符合定义
// 1、上n-1行同一列不能放
// 2、上n-1行m-1列不能放
// 3、上n-1行m+1列不能放
// 2、3为对角线判断，1为当前列
// 每次都查上一行，当前行也自动规避了

/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
    let result = new Array(n);
    let results = [];
    // 回溯排除
    // 判断 row 行 column 列放置是否合适
    let dfs = (row,column) => {
        let leftColumn =  column - 1;
        let rightColumn = column + 1;
        // 逐上判断每一行是否能放棋子
        for (let i = row - 1; i >= 0; i--) {
             // 第i行第column列是否有棋子【上一行同一列不能有棋子】
            if (result[i] === column) {
                return false;
            }
            // 当左列存在 && 考虑左上对角线【递减斜向上】 第i行第leftColumn列是否有棋子
            if (leftColumn >= 0 && result[i] === leftColumn) {
                return false;
            }
            // 当右列存在 && 考虑右上对角线【递减斜向上】 第i行第rightColumn列是否有棋子
            if (rightColumn < n && result[i] === rightColumn) {
                return false;
            }
            leftColumn--;
            rightColumn++;
        }
        return true;
    }
    // 格式化数据格式
    let format = (result) => {
        let tmpResult = [];
        for (let i = 0; i < n; i++) {
            let str = '';
            for (let j = 0; j < n; j++){
                if (result[i] === j) {
                    str += 'Q';
                } else {
                    str += '.';
                }
            }
            tmpResult.push(str);
        }
        return tmpResult;
    }
    // 开始搜索
    let Nqueens = (row) => {
        // 排除到最后一行，即当前所有行均排查过，
        // 意味着找到了一个解
        if(row == n){
            results.push(format(result));
            return;
        }
        for(let j = 0;j < n;j++){
            if(dfs(row,j)){
                result[row] = j;
                Nqueens(row+1)
            }
        }
    }
    // 从第一行开始搜索
    Nqueens(0);
    return results;
};