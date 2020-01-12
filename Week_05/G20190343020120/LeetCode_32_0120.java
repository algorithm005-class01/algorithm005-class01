/***
 *动规就是找循环
 *
 * **/
public class LeetCode_32_0120 {
    public int longestValidParentheses(String s) {
        //定义结果
        int ma = 0;
        //定义DP状态数组
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            //
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                ma = Math.max(ma, dp[i]);
            }
        }
        return ma;
    }
}
