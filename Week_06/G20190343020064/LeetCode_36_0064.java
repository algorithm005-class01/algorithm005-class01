package G20190343020064;

import java.util.*;

/**
 * <p>
 * 有效的数独
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-26 10:15 下午
 */
public class LeetCode_36_0064 {


    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] row = new HashSet[9];
        Set<Character>[] line = new HashSet[9];
        Set<Character>[] block = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            line[i] = new HashSet<>();
            block[i] = new HashSet<>();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int index = (i / 3) * 3 + j / 3;
                    if (row[i].contains(board[i][j]) || line[j].contains(board[i][j])  || block[index].contains(board[i][j])) {
                        return false;
                    } else {
                        row[i].add(board[i][j]);
                        line[j].add(board[i][j]);
                        block[index].add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }

}
