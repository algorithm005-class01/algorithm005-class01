class Solution {
    public int countSubstrings(String s) {
        if (null == s) {
            return 0;
        }
        if (1 >= s.length()) {
            return s.length();
        }

        int len = s.length(),count = 0;
        boolean[][] dp = new boolean[len][len];
        for (int j = 0; j < len; j++) {
            //以对角线形式遍历
            for (int i = 0; i <= j ; i++) {
                if (i == j) {
                    dp[i][j] = true;
                    count ++;
                    continue;
                }
                
                if ( s.charAt(i) == s.charAt(j) && (j - i==1|| dp[i+1][j-1])) {
                    
                    dp[i][j] = true;
                    count ++;
                }
            }
        }
        return count;
    }
}
