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


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<Set<Character>> rowList = new ArrayList<>();
    private List<Set<Character>> colunmList = new ArrayList<>();
    private List<Set<Character>> blockList = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        initSet(board);
        backtrace(board);
    }

    private boolean backtrace (char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]=='.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValide(i, j, k)) {
                            board[i][j] = k;
                            putNum(i, j, k);
                            if (backtrace(board)) {
                                return true;
                            } else {
                                removeNum(i, j, board[i][j]);
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

    private void initSet (char[][] board) {
        for (int i = 0; i < board.length; i++) {
            rowList.add(new HashSet<>());
            colunmList.add(new HashSet<>());
            blockList.add(new HashSet<>());
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]!='.') {
                    putNum(i, j, board[i][j]);
                }
            }
        }
    }



    private boolean isValide (int row, int colunm, char num) {
        int block = row/3*3+colunm/3;
        if (!rowList.get(row).contains(num)
                && !colunmList.get(colunm).contains(num)
                && !blockList.get(block).contains(num)) {
            return true;
        }
        return false;
    }

    private void putNum (int row, int colunm, char num) {
        int block = row/3*3+colunm/3;
        rowList.get(row).add(num);
        colunmList.get(colunm).add(num);
        blockList.get(block).add(num);
    }

    private void removeNum (int row, int column, char num) {
        int block = row/3*3+column/3;
        rowList.get(row).remove(num);
        colunmList.get(column).remove(num);
        blockList.get(block).remove(num);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
