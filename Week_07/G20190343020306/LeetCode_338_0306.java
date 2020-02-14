class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 1) {
                //奇数比前面的偶数多一个1
                dp[i] = dp[i - 1] + 1;     
            } else {
                //偶数与它除以2(右移一位)后的数一样多
                dp[i] = dp[i / 2];
            }
        }
        return dp;
    }
}