class Solution {
    private int rowLen, colLen;
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0], col = click[1];
        rowLen = board.length;
        colLen = board[0].length;
        dfs(board, row, col);
        return board;
    }

    private char[][] dfs(char[][] board, int row, int col) {
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }
        if (board[row][col] == 'E') {
            List<int[]> list = pos(board, row, col);
            int count = 0;
            for (int[] pos : list) {
                count += mine(board, pos[0], pos[1]);
            }

            board[row][col] = count > 0 ? (char)(count + '0') : 'B';
            if (count == 0) {
                for (int[] pos : list) {
                    if (board[pos[0]][pos[1]] != 'E') continue;
                    dfs(board, pos[0], pos[1]);
                }
            }
        }
        return board;
    }

    private int mine(char[][] board, int row, int col) {
        return board[row][col] == 'M' ? 1 : 0;
    }
    
    private int[] direction = {-1, 0, 1};
    private List<int[]> pos(char[][] board, int row, int col) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < direction.length; i++) {
            for (int j = 0; j < direction.length; j++) {
                if (i == j && i == 1) continue;
                int r = row + direction[i];
                int c = col + direction[j];
                if (r < 0 || c < 0 || r >= rowLen || c >= colLen) continue;
                list.add(new int[]{r, c});
            }
        }
        return list;
    }
}