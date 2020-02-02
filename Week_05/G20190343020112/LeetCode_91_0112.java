class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        if (length == 0 || s.charAt(0) == '0') return 0;

        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') dp[i] = i > 1 ? dp[i - 2] : dp[i -1];
                else return 0;
            }else {
                if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                    dp[i] = dp[i - 1] + (i > 1 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }

        return dp[length - 1];
    }
}