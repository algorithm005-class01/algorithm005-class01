/*
    1. f(i, j)表示word1[0..i]的子串到word2[0..j]的子串的最短编辑距离
    2. 如果word1[i] = word2[j], 这个位置无需再变换, f(i, j) = min(f(i-1, j), f(i, j-1), f(i-1, j-1)-1) + 1
    3. 如果word1[i] != word2[j], 这个位置需要再作一次转换, f(i, j) = min(f(i-1, j), f(i, j-1), f(i-1, j-1)) + 1
    4. 边界条件, 从空串到word[i]的编辑距离为i+1
     */
public int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    //第0行第0列代表空串
    for (int i = 0; i <= word2.length(); i++) {
        dp[0][i] = i;
    }
    for (int i = 0; i <= word1.length(); i++) {
        dp[i][0] = i;
    }

    for (int i = 1; i <= word1.length(); i++) {
        for (int j = 1; j <= word2.length(); j++) {
            if (word1.charAt(i-1) == word2.charAt(j-1)) {
                dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]) + 1, dp[i-1][j-1]);
            } else {
                dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
            }
        }
    }
    return dp[word1.length()][word2.length()];

}