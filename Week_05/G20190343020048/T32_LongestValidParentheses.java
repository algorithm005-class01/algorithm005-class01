package main.leetcode_solutions.dynamic_programming;

/**
 * 最长合法括号
 */
public class T32_LongestValidParentheses {
    /**
     * 动态规划解法，重点对所有可能的情况进行分类讨论
     * dp[i]以位置i结尾的最长合法括号，状态转移方程如下
     * dp[i] = 0, (i = 0 || s[i] == '(')
     * dp[i] = dp[i - 2] + 2, (i >= 2 && s[i - 1] == '(')
     * dp[i] = 0, (i - 1 - dp[i - 1] < 0 || s[i - 1 - dp[i - 1]] == ')')
     * dp[i] = dp[i - 1] + 2, (i - 1 - dp[i - 1] == 0 && s[i - 1 - dp[i - 1]] == '(')
     * dp[i] = dp[i - 1] + 2 + dp[i - 2 - dp[i - 1]], (i - 1 - dp[i - 1] > 0 && s[i - 1 - dp[i - 1]] == '(')
     * 通过一些编程技巧，可以将上述的几种情况合并，写出较为简洁的代码
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '('){
                continue;
            }
            if (s.charAt(i - 1) == '('){
                dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
            } else {
                int sym = i - 1 - dp[i - 1];
                if (sym >= 0 && s.charAt(sym) == '('){
                    dp[i] = sym - 1 >= 0 ? dp[sym - 1] +  dp[i - 1] + 2 : dp[i - 1] + 2;
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
