class Solution {
    public int longestValidParentheses(String s) {
        /**
         * 思路：该问题最主要要分解的子问题总共有两部分
         * 1.如果当前为右括号，如果前一个为左括号的话，只需要在之前的有效长度上加2
         * 2.如果当前为右括号，如果前一个也为右括号，并且前一个的有效长度之前那一位为左括号的话，则在在之前的有效长度下加2，然后再将之前可能有的结果加上
         */

        if (s == null) return 0;
        int max = 0;
        int[] dp = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            //有效字符串必定是以右括号结尾
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}