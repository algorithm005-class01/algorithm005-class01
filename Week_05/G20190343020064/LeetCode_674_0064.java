package G20190343020064;

/**
 * <p>
 * 回文子串
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-12 11:33 下午
 */
public class LeetCode_674_0064 {

    /**
     * dp[i][j] = dp[i+1][j-1] && str[i]==str[j]
     * 这题还来得及细想。。。
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int res = 0;
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && ((j - i < 2) || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }

}
