package main.leetcode_solutions.bit_operation;

/**
 * @author wenzhuang
 * @date 2020/2/9 8:34 PM
 */
public class T52_NQueensII {
    int count = 0;
    public int totalNQueens(int n) {
        dfs(0, n, 0, 0 ,0);
        return count;
    }

    private void dfs(int row, int n, int col, int pie, int na){
        if (row == n){
            count++;
            return;
        }
        int bits = (~(col | pie | na)) & ((1 << n) - 1);
        while (bits != 0){
            int p = bits & -bits;
            dfs(row + 1, n, col | p, (pie | p) << 1, (na | p) >> 1);
            bits &= bits - 1;
        }
    }
}
