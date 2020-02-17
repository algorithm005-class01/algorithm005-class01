package com.log8.week08;

public class Solution72 {
    public int minDistance(String word1, String word2) {
        if(word1==null||word2==null) return 0;
        if(word1.equals("")) return word2.length();
        if(word2.equals("")) return word1.length();
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1+1][length2+1];

        for(int i=0;i<length1+1;i++){
            dp[i][0] = i;
        }
        for(int j=0;j<length2+1;j++){
            dp[0][j] = j;
        }

        for(int i=1;i<length1+1;i++){
            for(int j=1;j<length2+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1]);
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        Solution72 s72 = new Solution72();
        System.out.println(s72.minDistance(word1, word2));
    }
}
