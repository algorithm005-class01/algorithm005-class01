package G20190343020064;

/**
 * <p>
 * 编辑距离
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-02-02 9:42 下午
 */
public class LeetCode_72_0064 {

    /**
     *   r o o
     * h 1 2 3
     * e 1 2 3
     * o 2 2 2
     * dp方程
     * 当 word1[i] != word2[j] 的情况
     * dp[i-1][j] -> dp[i][j]  相当于 新增一个字母 (h -> r) = i => (he -> r) = j ，则 j = i 的基础上 删除字母 j = i + 1
     * dp[i][j-1] -> dp[i][j]  相当于 删除一个字母 (he -> r) = i => (he - ro) = j, 则 j = i 的基础上 新增字母 j = i + 1
     * dp[i-1][j-1] -> dp[i][j] 相当于 替换 (h -> r) =i => (he -> ro) = j  i 为 1(替换) 则 j  为 i 的基础上 e 替换为 o 则 j = i + 1
     *
     * 当 word1[i] == word2[j] 的情况
     * dp[i][j] = dp[i-1][j-1] 因为最后一个字母相同则不需要计算该字母变动，例如 heo -> roo = he -> ro ，
     *
     * 所以有
     * 当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1];
     * 当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return word1.length() == 0 ? word2.length() : word1.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];

    }
}
