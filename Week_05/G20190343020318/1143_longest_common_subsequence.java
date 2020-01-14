class Solution {
    public int longestCommonSubsequence2(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) return 0;
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 0; i < chars1.length; ++i)
            for (int j = 0; j < chars2.length; ++j)
                dp[i + 1][j + 1] = chars1[i] == chars2[j] ? dp[i][j] + 1 : Math.max(dp[i + 1][j], dp[i][j + 1]);
        return dp[chars1.length][chars2.length];
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) return 0;
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; ++i)
            for (int j = 1; j < n + 1; ++j)
                dp[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1) ? 
                    dp[i - 1][j - 1] + 1 : 
                    Math.max(dp[i - 1][j], dp[i][j - 1]);
        return dp[m][n];
    }
}


