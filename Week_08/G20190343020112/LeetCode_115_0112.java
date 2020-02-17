class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                dp[i][j] = t.charAt(i - 1) == s.charAt(j - 1) ? dp[i - 1][j - 1] + dp[i][j - 1] : dp[i][j - 1];
            }
        }
        return dp[t.length()][s.length()];
    }
}