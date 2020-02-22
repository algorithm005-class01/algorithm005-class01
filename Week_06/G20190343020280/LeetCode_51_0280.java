//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
//
//
// 上图为 8 皇后问题的一种解法。
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
//
// 示例:
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
//
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final char Q = 'Q';
    private List<List<String>> result = new ArrayList<>();

    private int[] row;
    private int[] pie;
    private int[] na;
    private int[] queens;
    private int m;

    public List<List<String>> solveNQueens(int n) {
        row = new int[n];
        pie = new int[2*n-1];
        na = new int[2*n-1];
        queens = new int[n];
        m = n;
        solveByArray(0);

        return result;
    }

    private void solveByArray (int curLevel) {
        if (curLevel==queens.length) {
            return;
        }
        for (int i = 0; i < m; i++) {
            if (isInvalid(curLevel, i)) {
                putQueens(curLevel, i, 1);
                if (curLevel==m-1) {
                    buildResult();
                }
                solveByArray(curLevel+1);
                putQueens(curLevel, i, 0); //恢复状态
            }
        }

    }

    private boolean isInvalid (int x, int y) {
        if (row[y]+pie[x-y+m-1]+na[x+y]==0) {
            return true;
        }
        return false;
    }

    private void putQueens (int x, int y, int flag) {
        queens[x] = y;
        row[y] = flag;
        pie[x-y+m-1] = flag;
        na[x+y] = flag;
    }

    private void buildResult () {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringBuilder builder = new StringBuilder();
            int col = queens[i];
            for (int j = 0; j < col; j++) {
                builder.append('.');
            }
            builder.append(Q);
            for (int j = col+1; j <m ; j++) {
                builder.append('.');
            }
            board.add(builder.toString());
        }
        result.add(board);
    }


    private void solveQueens (char[][] board, int curLevel, int max, List<List<String>> result) {
        if (curLevel==max) {
            result.add(toList(board));
        }
        for (int i = 0; i < max; i++) {
            if (isValid(board, curLevel, i)) {
                board[curLevel][i] = 'Q';
                solveQueens(board, curLevel+1, max, result);
                board[curLevel][i] = '.'; //恢复当前层状态
            }
        }
    }

    private boolean isValid (char[][] board, int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]=='Q' && (row==i || column==j || i-row==j-column || i-row==column-j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> toList (char[][] board) {
        List<String> arrayList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                builder.append(board[i][j]);
            }
            arrayList.add(builder.toString());
        }
        return arrayList;
    }

    private char[][] initBoard (int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        return board;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
