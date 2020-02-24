class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') solveDfs(board, i, 0);
            if (board[i][board[i].length - 1] == 'O') solveDfs(board, i, board[i].length - 1);
        }
        for (int i = 1; i < board[0].length - 1; i++) {
            if (board[0][i] == 'O') solveDfs(board, 0, i);
            if (board[board.length - 1][i] == 'O') solveDfs(board, board.length - 1, i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'K') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    private void solveDfs(char[][] board, int i, int j) {
        board[i][j] = 'K';
        if (i > 0 && board[i - 1][j] == 'O') solveDfs(board, i - 1, j);
        if (j > 0 && board[i][j - 1] == 'O') solveDfs(board, i, j - 1);
        if (i < board.length - 1 && board[i + 1][j] == 'O') solveDfs(board, i + 1, j);
        if (j < board[0].length - 1 && board[i][j + 1] == 'O') solveDfs(board, i, j + 1);
    }
}
