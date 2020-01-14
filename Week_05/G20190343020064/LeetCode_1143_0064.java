package G20190343020064;

/**
 * <p>
 * 最长公共子序列
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-07 11:48 下午
 */
public class LeetCode_1143_0064 {


    /**
     * 相比下面那种方式，通过扩展一行纬度，来通用代码，提高代码简洁度
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int[][] map = new int[text1.length() + 1][text2.length() + 1];
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    map[i + 1][j + 1] = map[i][j] + 1;
                } else {
                    map[i + 1][j + 1] = Math.max(map[i][j + 1], map[i + 1][j]);
                }
            }
        }
        return map[text1.length()][text2.length()];
    }

    /**
     * 用了维护数组缓存数据 其实同样可以用一维数组搞定
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence2(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int[][] map = new int[text1.length()][text2.length()];
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int flag = 0;
        for (int i = 0; i < chars1.length; i++) {
            if (flag == 0) {
                if (chars1[i] == chars2[0]) {
                    map[i][0] = 1;
                    flag = 1;
                }
            } else {
                map[i][0] = 1;
            }
        }
        flag = 0;
        for (int i = 0; i < chars2.length; i++) {
            if (flag == 0) {
                if (chars2[i] == chars1[0]) {
                    map[0][i] = 1;
                    flag = 1;
                }
            } else {
                map[0][i] = 1;
            }
        }
        for (int i = 1; i < chars1.length; i++) {
            for (int j = 1; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    map[i][j] = map[i - 1][j - 1] + 1;
                } else {
                    map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
                }
            }
        }
        return map[text1.length() - 1][text2.length() - 1];
    }
}
