import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_51_0190 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        helper(0, new boolean[n], new boolean[2 * n], new boolean[2 * n], new LinkedList<>(), result, n);
        return result;
    }

    private void helper(int r, boolean[] cols, boolean[] d1, boolean[] d2, List<String> board, List<List<String>> result, int n) {
        if (r == cols.length) result.add(new ArrayList<>(board));
        else {
            for (int i = 0; i < n; i++) {
                int id1 = r - i + n, id2 = (n << 1) - r - i - 1;
                if (!cols[i] && !d1[id1] && !d2[id2]) {
                    char[] row = new char[cols.length];
                    Arrays.fill(row, '.'); row[i] = 'Q';
                    board.add(r, new String(row));
                    cols[i] = true; d1[id1] = true; d2[id2] = true;
                    helper(r + 1, cols, d1, d2, board, result, n);
                    cols[i] = false; d1[id1] = false; d2[id2] = false;
                    board.remove(r);
                }
            }
        }
    }
}
