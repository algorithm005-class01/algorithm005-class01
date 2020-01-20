package Week_06.G20190343020220.leetcode_37_0220;

/**
 * @author Darcy
 * @date 2020-01-20 12:40
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        this.solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    /*枚举1-9*/
                    for (char c = '1'; c <= '9'; c++) {
                        /*验证是否有效  是否可以放这个数字*/
                        if (this.isValid(board, i, j, c)) {
                            board[i][j] = c;
                            /*继续解决下一个*/
                            if (this.solve(board)) {
                                return true;
                            } else {
                                /*回溯*/
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            /*验证列中没有等于c的*/
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            /*验证行中没有等于c的*/
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            /*验证矩阵中没有等于c的*/
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
