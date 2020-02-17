//编写一个程序，通过已填充的空格来解决数独问题。 
//
// 一个数独的解法需遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。 
// 
//
// 空白格用 '.' 表示。 
//
// 
//
// 一个数独。 
//
// 
//
// 答案被标成红色。 
//
// Note: 
//
// 
// 给定的数独序列只包含数字 1-9 和字符 '.' 。 
// 你可以假设给定的数独只有唯一解。 
// 给定数独永远是 9x9 形式的。 
// 
// Related Topics 哈希表 回溯算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final char FLAG = '.';

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == FLAG) {
                    for (char c = '1'; c <= '9'; c++) {
                        // 如果填入当前值 c，状态集正常，则继续查找下一个 '.'
                        if (isValidSudoku(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            }
                            // 回溯时回复当前格子状态
                            board[i][j] = FLAG;
                        }
                    }
                    // 如果当前格子填入 1-9 都不能满足条件，则无法解析
                    return false;
                }
            }
        }
        return true;
    }

    // 判断新增 c 之后，当前状态是否有效
    public boolean isValidSudoku(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // 行包含了当前字符 c，则认为无效
            if (board[i][col] != FLAG && board[i][col] == c) {
                return false;
            }

            // 列包含了当前字符 c，则认为无效
            if (board[row][i] != FLAG && board[row][i] == c) {
                return false;
            }

            // 当前块包含了当前字符 c，则认为无效
            char blockChar = board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3];
            if (blockChar != FLAG && blockChar == c) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
