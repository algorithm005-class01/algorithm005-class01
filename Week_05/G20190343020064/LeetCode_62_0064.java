package G20190343020064;

import java.util.Arrays;

/**
 * <p>
 * 不同路径
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-06 10:44 下午
 */
public class LeetCode_62_0064 {

    /**
     * 自底向上递推
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i][m - 1] = 1;
        }
        for (int i = 0; i < m; i++) {
            map[n - 1][i] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                map[i][j] = map[i + 1][j] + map[i][j + 1];
            }
        }
        return map[0][0];
    }

    /**
     * 可以用一维数组解决
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths4(int m, int n) {
        int[] map = new int[m];
        Arrays.fill(map, 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                map[j] = map[j] + map[j + 1];
            }
        }
        return map[0];
    }


    /**
     * 有缓存递归
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        int[][] map = new int[n][m];
        recursive2(map, 0, 0);
        return map[0][0];
    }

    public int recursive2(int[][] map, int m, int n) {
        if (n == map.length - 1) {
            map[n][m] = 1;
            return map[n][m];
        }
        if (m == map[n].length - 1) {
            map[n][m] = 1;
            return map[n][m];
        }
        if (map[n][m] == 0) {
            map[n][m] = recursive2(map, m + 1, n) + recursive2(map, m, n + 1);
        }
        return map[n][m];
    }

    /**
     * 无缓存 必定超时。。。
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths3(int m, int n) {
        return recursive3(0, 0, m, n);
    }

    public int recursive3(int i, int j, int m, int n) {
        if (i == n - 1) {
            return 1;
        }
        if (j == m - 1) {
            return 1;
        }
        return recursive3(i + 1, j, m, n) + recursive3(i, j + 1, m, n);
    }
}
