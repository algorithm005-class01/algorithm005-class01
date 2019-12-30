package Week_03.G20190343020220.leetcode_51_0220;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Darcy
 * @date 2019-12-27 15:38
 */
public class Solution {


    private List<List<String>> solution;
    private char[][] nQueens;
    private boolean[] colUsed;
    private boolean[] diagonals45Used;
    private boolean[] diagonals135Used;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        solution = new ArrayList<>();
        nQueens = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.');
        }
        colUsed = new boolean[n];
        diagonals45Used = new boolean[2 * n - 1];
        diagonals135Used = new boolean[2 * n - 1];
        this.n = n;
        back(0);
        return solution;
    }

    public void back(int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] c : nQueens) {
                list.add(new String(c));
            }
            solution.add(list);
            return;
        }
        for (int col = 0; col < n; col++) {
            int diagonals45Idx = row + col;
            int diagonals135Idx = n - 1 - (row - col);
            if (colUsed[col] || diagonals45Used[diagonals45Idx] || diagonals135Used[diagonals135Idx]) {
                continue;
            }
            nQueens[row][col] = 'Q';
            colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = true;
            back(row + 1);
            colUsed[col] = diagonals45Used[diagonals45Idx] = diagonals135Used[diagonals135Idx] = false;
            nQueens[row][col] = '.';
        }
    }


}
