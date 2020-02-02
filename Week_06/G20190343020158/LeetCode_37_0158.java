class Solution {
    /**
     *思路：本题应用了回溯的思想
     * 在遍历棋盘的时候，遇到.时，尝试将1-9填入，然后判断是否符合数独规则
     * 符合则填入最后知道完成，不符合则回溯，重新改为.，等待下一次遍历
     */
    public void solveSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        solve(board, rows, cols);

    }

    private boolean solve(char[][] board, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char num = board[i][j];
                if (num == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (valid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board, rows, cols)) {
                                return true;
                            } else {
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

    private boolean valid(char[][] board, int row, int col, char c) {
        int blockRow = (row / 3) * 3;
        int blockCol = (col / 3) * 3;
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;
            if (board[blockRow + i / 3][blockCol + i % 3] == c) return false;
        }
        return true;
    }
}