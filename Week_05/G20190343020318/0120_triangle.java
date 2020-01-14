class Solution {
    public int minimumTotal2(List<List<Integer>> triangle) {
        //  bottom to top
        int m = triangle.size();
        int[] dp = new int[m + 1];
        for (int i = m - 1; i >= 0; --i) { //  bottom to top
            for (int j = 0; j <= i; ++j) { //  left to right
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}

