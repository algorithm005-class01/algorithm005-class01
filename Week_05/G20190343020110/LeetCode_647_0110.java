/**
 * @Author huangxiong
 * @Date 2020/1/9
 * @Description
 **/
public class LeetCode_647_0110 {
    /**
     * 动态规划
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if (dp[i][j]) ++res;
            }
        }
        return res;
    }
}
