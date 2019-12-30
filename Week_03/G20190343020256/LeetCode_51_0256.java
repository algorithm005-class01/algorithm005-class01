package Week3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 */
public class LeetCode_51_0256 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> cols = new ArrayList<>();
    List<Integer> pie = new ArrayList<>();
    List<Integer> na = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return new ArrayList<>();
        dfs(0, n, new ArrayList<>());
        return generateResults(n);

    }

    private List<List<String>> generateResults(int n) {

        return result.stream().map(list -> list.stream().map(integer -> {
            String[] s = new String[n];
            Arrays.fill(s, ".");
            s[integer] = "Q";
            return Arrays.toString(s);
        }).collect(Collectors.toList())).collect(Collectors.toList());
    }

    private void dfs(int row, int n, List<Integer> curState) {
        if (row >= n) {
            result.add(curState);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pie.contains(col + row) || na.contains(col - row)) {
                continue;
            }
            pie.add(col + row);
            na.add(col - row);
            cols.add(col);

            curState.add(col);
            dfs(n, row+1, curState);


            curState.remove(curState.size() - 1);
            cols.remove(new Integer(col));
            na.remove(new Integer(col-row));
            pie.remove(new Integer(col+row));
        }

    }
}
