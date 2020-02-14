class Solution {
    public int totalNQueens(int n) {
        return backtrack(0, 0, 0, (1 << n) - 1, 0, n, 0);
    }

    private int backtrack(int cols, int maindiagonals, int subdiagonals, int init, int row, int n, int count) {
        if (row == n) {
            count++;
        } else {
            int pos = init & ~(cols | maindiagonals | subdiagonals);
            while (pos != 0) {
                int p = (-pos & pos);
                count = backtrack(cols | p, (maindiagonals | p) << 1, (subdiagonals | p) >> 1, init, row + 1, n, count);
                pos &= (pos - 1);
            }
        }
        return count;
    }
}