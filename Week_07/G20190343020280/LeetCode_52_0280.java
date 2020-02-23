//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
//
// 示例:
//
// 输入: 4
//输出: 2
//解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//
// Related Topics 回溯算法



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int n;
    int restult = 0;

    public int totalNQueens(int n) {
        int[] column = new int[n];
        int[] pie = new int[2*n-1];
        int[] na = new int[2*n-1];
        this.n = n;
        solveQueens(0, column, pie, na);
        return restult;
    }

    private int solveQueens (int curLevel, int[] column, int[] pie, int[] na) {
        for (int i = 0; i <n; i++) {
            if (isValid(column, pie, na, curLevel, i)) {
                putQueens(column, pie, na, curLevel, i, 1);
                if (curLevel==n-1) {
                    ++restult;
                } else {
                    solveQueens(curLevel+1, column, pie, na);
                }
                putQueens(column, pie, na, curLevel, i, 0);
            }
        }
        return restult;
    }

    private void putQueens (int[] column, int[] pie, int[] na, int rowIndex, int columnInex, int flag) {
        column[columnInex] = flag;
        pie[rowIndex-columnInex+n-1] = flag;
        na[rowIndex+columnInex] = flag;
    }

    private boolean isValid (int[] column, int[] pie, int[] na, int rowIndex, int columnIndex) {
        return column[columnIndex]+pie[rowIndex-columnIndex+n-1]+na[rowIndex+columnIndex]==0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
