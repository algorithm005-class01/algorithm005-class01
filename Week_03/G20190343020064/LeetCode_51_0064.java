package G20190343020064;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * N皇后
 * </p>
 *
 * @author mingke.yan@hand-china.com 2019-12-27 9:48 上午
 */
public class LeetCode_51_0064 {


    public List<List<String>> result = new ArrayList<>();

    /**
     * ↘对角线  row - line = const [-n - n] 通过处理 -> +n -> [0 - 2n]
     */
    public int[] main;

    /**
     * ↙对角线 row + line = const [0 - 2n]
     */
    public int[] second;

    /**
     * 列是否占用
     */
    public int[] third;

    public List<List<String>> solveNQueens(int n) {
        main = new int[2 * n];
        second = new int[2 * n];
        third = new int[n];
        this.solveNQueens(n, 0, new int[n]);
        return result;
    }

    public void solveNQueens(int n, int row, int[] lines) {
        if (row == n) {
            result.add(this.convert(lines));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!this.valid(row, i, n)) {
                continue;
            }
            lines[row] = i;
            this.solveNQueens(n, row + 1, lines);
            lines[row] = 0;
            this.removeCache(row, i, n);
        }
    }

    /**
     * 判断当前位置是否有效
     * 有效则记录该位置并返回
     * 无效则直接返回结果
     *
     * @param row
     * @param line
     * @param n
     * @return
     */
    public boolean valid(int row, int line, int n) {
        int mainIndex = row - line + n;
        int secondIndex = row + line;
        boolean isValid = main[mainIndex] == 0 && second[secondIndex] == 0 && third[line] == 0;
        if (isValid) {
            main[mainIndex] = 1;
            second[secondIndex] = 1;
            third[line] = 1;
        }
        return isValid;
    }

    /**
     * 清除皇后存放缓存
     */
    public void removeCache(int row, int line, int n) {
        int mainIndex = row - line + n;
        int secondIndex = row + line;

        main[mainIndex] = 0;
        second[secondIndex] = 0;
        third[line] = 0;
    }

    /**
     * 生成棋盘
     * @param lines
     * @return
     */
    public List<String> convert(int[] lines){
        List<String> list = new ArrayList<>();
        for (int line : lines) {
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < lines.length; i++) {
                if (line == i) {
                    str.append("Q");
                } else {
                    str.append(".");
                }
            }
            list.add(str.toString());
        }
        return list;
    }


}
