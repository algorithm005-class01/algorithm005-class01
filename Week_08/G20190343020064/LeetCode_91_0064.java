package G20190343020064;


/**
 * <p>
 * 解码方法
 * </p>
 *
 * @author mingke.yan@hand-china.com 2020-02-16 4:26 下午
 */
public class LeetCode_91_0064 {

    /**
     * 其实和爬楼梯类似 但是有其他限制条件
     * <p>
     * s[i] != '0'
     * s[i-1]s[i] <= 26  dp[i] = dp[i-1] + dp[i-2]
     * s[i-1]s[i] > 26   dp[i] = dp[i-1]
     * <p>
     * s[i] == '0'
     * s[i] = s[i-2]
     *
     *
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != '0') {
                // 对应 101 这种情况
                if (chars[i - 1] == '0') {
                    dp[i + 1] = dp[i - 2 + 1];
                    continue;
                }
                if ((chars[i - 1] - 48) * 10 + (chars[i] - 48) < 27) {
                    dp[i + 1] = dp[i - 1 + 1] + dp[i - 2 + 1];
                } else {
                    dp[i + 1] = dp[i - 1 + 1];
                }
            } else {
                // 对于 '30' 这种情况
                if (chars[i - 1] - 48 > 2) {
                    return 0;
                }
                // 对应 '00' 这种情况
                if (chars[i - 1] == '0') {
                    return 0;
                }
                dp[i + 1] = dp[i - 2 + 1];
            }
        }
        return dp[s.length()];
    }

}
