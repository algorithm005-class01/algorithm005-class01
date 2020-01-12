package G20190343020064;

/**
 * <p>
 * 最长有效括号
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-01-12 10:57 下午
 */
public class LeetCode_32_0064 {


    /**
     * dp 递推公式 dp[] 存放当前下标的最长合法长度
     * if i = ')' and i-1 = '('   dp[i] = dp[i-2] + 2
     * if i = ')' and i-1 = ')'   dp[i] = dp[i-1] + dp[i - dp[i-1] - 2] + 2
     * 对于 dp[i - dp[i-1] - 2] 这种情况  是对这种可能的情况 ()'('()()()) 针对第三个 '(' 把前面的合法括号加进去
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s.length() < 2) return 0;
        int[] dp = new int[s.length()];
        int maxLength = 0;
        for (int i = 1; i < s.length(); i++) {
            if (')' == s.charAt(i)) {
                if ('(' == s.charAt(i - 1)) {
                    dp[i] = (i < 2 ? 0 : dp[i - 2]) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    System.out.println((i - dp[i - 1]) < 2);
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) < 2 ? 0 : dp[i - dp[i - 1] - 2]) + 2;
                }
                maxLength = Math.max(dp[i], maxLength);
            }
        }
        return maxLength;
    }

}
