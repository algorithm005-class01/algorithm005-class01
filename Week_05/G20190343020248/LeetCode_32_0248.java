package com.gome.study;
//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。

/**
 * 1.将 dp 数组全部初始化为 0 。现在，很明显有效的子字符串一定以 ‘)’结尾。
 * 2.以 ‘(’ 结尾的子字符串对应的 dp 数组位置上的值必定为 0
 * 3.只需要更新 ‘)’ 在 dp 数组中对应位置的值即可
 * <p>
 * dp[i]=dp[i−2]+2
 * dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
 * <p>
 * 时间复杂度：O(n),遍历整个字符串一次，就可以将 dp 数组求出来。
 * <p>
 * 空间复杂度：O(n),需要一个大小为 n 的 dp 数组。
 */

public class LeetCode_32_0248 {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}