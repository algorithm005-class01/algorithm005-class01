class Solution {
private void dfs(char[][] board, int row, int n, List<List<String>> res, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            List<String> toAdd = new ArrayList<String>();
            for (int i = 0; i < n; ++i)
                toAdd.add(String.valueOf(board[i]));
            res.add(toAdd);
            return;
        }

        for (int col = 0; col < n; ++col) {
            //  diag1 index = row + n - col - 1
            //  diag2 index = row + col
            if (cols[col] || diag1[row + n - col - 1] || diag2[row + col])
                continue;
            //  mark current level
            cols[col] = true;
            diag1[row + n - col - 1] = true;
            diag2[row + col] = true;
            board[row][col] = 'Q';

            //  drill down
            dfs(board, row + 1, n, res, cols, diag1, diag2);

            //  reverse current level
            board[row][col] = '.';
            cols[col] = false;
            diag1[row + n - col - 1] = false;
            diag2[row + col] = false;
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        //  reusable board
        char[][] curr = new char[n][n];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                curr[i][j] = '.';
            }
        }

        //  instead of using hash
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; //  2*n for negative diag1 index
        boolean[] diag2 = new boolean[2 * n - 1]; //  2*n for negative diag1 index
        //  start dfs
        dfs(curr, 0, n, res, col, diag1, diag2);
        return res;
    }
}