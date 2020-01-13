package Week_05.G20190343020220.leetcode_32_0220;

/**
 * @author Darcy
 * @date 2020-01-12 11:31
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int m = s.length();
        int[] dp = new int[m];
        int max = 0;
        for (int i = 1; i < m; i++) {
            if (s.charAt(i) == ')') {
                /*()的情况*/
                if (s.charAt(i - 1) == '(') {
                    /*i>=2 说明前面可能出了有效括号. dp[i-2]既是前边有效括号的数量*/
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    /*))的情况*/
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    /*dp[i-1]第一个)有效括号的数量, i- dp[i - 1] >2 的意思是  ()5(()) 在5位置之前 并不是数组的开头也就是存在有效括号. 他的有效括号是多少呢
                     * dp[i - dp[i - 1] - 2]
                     * */
                    dp[i] = dp[i - 1] + (i - dp[i - 1] > 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;

    }

    public int longestValidParentheses1(String s) {
        int m = s.length();
        int left = 0, right = 0;
        int max = 0;
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        for (int i = m - 1; i >= 0; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return max;
    }
}
