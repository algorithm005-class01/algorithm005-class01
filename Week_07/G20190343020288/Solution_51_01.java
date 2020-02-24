package week_07.commit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 51. N皇后
// https://leetcode-cn.com/problems/n-queens/description/
public class Solution_51_01 {

    // 位运算解法
    private List<String> result = new ArrayList<>();
    private List<List<String>> results = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }

        dfs(n, 0, 0, 0);

        return results;
    }

    private void dfs(int n, int col, int pie, int na) {
        if (n == result.size()) {
            results.add(new ArrayList<String>(result));
            return;
        }

        // 获得所有的有效空位
        // (col | pie | na) 可以得到所有被占的空位，取反之后将有效空位置为 1
        // 与上 (1 << n) - 1，是设定考虑范围，比如 8 皇后，那么只用考虑低 8 位即可
        int bit = ((~(col | pie | na)) & ((1 << n) - 1));

        // bit > 0 表示有空位
        while (bit > 0) {
            // 选择最低位的一个空位
            int tmp = bit & (-bit);

            // 构建当前行的答案
            String str = constructString(tmp, n);
            result.add(str);

            // col | tmp 是将 col 中当前选择的这一列置为 1，也就是无效
            // (pie | tmp) << 1 是设置之前行和当前行对左下的影响
            // (na | tmp) >> 1 是设置之前行和当前行对右下的影响
            dfs(n, col | tmp, (pie | tmp) << 1, (na | tmp) >> 1);

            result.remove(result.size() - 1);

            // 将当前选择的这个最低位置为 0
            bit &= bit - 1;
        }
    }

    private String constructString(int i, int n) {
        char[] row = new char[n];
        Arrays.fill(row, '.');
        int tmp = 1, indx = 0;

        while (i != 0) {
            if ((tmp & i) != 0) {
                row[indx] = 'Q';
            }

            i >>= 1;
            indx++;
        }
        return new String(row);
    }

}
