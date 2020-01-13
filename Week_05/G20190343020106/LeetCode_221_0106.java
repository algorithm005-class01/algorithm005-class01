package Week05;

class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int maxLen = 0;
        for (int i=0; i<matrix.length;++i){
            for (int j=0;j<matrix[0].length;++j) {
                if (matrix[i][j] == '1') {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j+1], dp[i+1][j]), dp[i][j])+1;
                    maxLen = Math.max(maxLen, dp[i+1][j+1]);
                }
            }
        }
        return maxLen * maxLen;
    }
}
