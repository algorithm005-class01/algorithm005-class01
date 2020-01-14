class Solution {
    public int numDecodings(String s) {
        /**
         * 思路：对题意要理解正确，自己做的时候理解错误题意，把题目想成类似数字之间排列组合的问题，
         * 但实际情况是除了考虑不同组合外，还要考虑0的情况
         */
        if (s == null) return 0;
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        if (s.charAt(s.length() - 1) != '0') {
            dp[s.length() - 1] = 1;
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            }
            int ans1 = dp[i + 1];
            int ans2 = 0;

            int ten = (s.charAt(i) - '0') * 10;
            int one = s.charAt(i + 1) - '0';
            if (ten + one <= 26) {
                ans2 = dp[i + 2];
            }
            dp[i] = ans1 + ans2;
        }
        return dp[0];
    }
}