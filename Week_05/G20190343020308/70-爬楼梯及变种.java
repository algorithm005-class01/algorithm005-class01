// class Solution {
//     public int climbStairs(int n) {
//         int[] dp = new int[n+1];
//         if (n == 1 || n ==2) return n;
//         dp[0] = 0;
//         dp[1] = 1;
//         dp[2] = 2;
//         for (int i =3; i < n + 1; i++) {
//         dp[i] = dp[i-1] + dp[i-2];
//         }
//         return dp[n];
//     }
// }

//1、2、3 三种爬楼方式
// class Solution {
//     public int climbStairs(int n) {
//         int[] dp = new int[n+1];
//         if (n == 1 || n ==2) return n;
//         if (n ==3) return 4;
//         dp[0] = 0;
//         dp[1] = 1;
//         dp[2] = 2;
//         dp[3] = 4;
//         for (int i = 4; i < n + 1; i++) {
//         dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
//         }
//         return dp[n];
//     }
// }

// 相邻步伐不同
class Solution {
    public int climbStairs(int n) {

        int[] sum = new int[n+1];
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        int[] c = new int[n+1];
        if (n == 1 || n == 2) return 1;
        if (n == 3) return 3;
        a[1] = 1;
        b[2] = 1;
        c[3] = 1;
        a[3] = 1;
        b[3] = 1;
        sum[1] = 1;
        sum[2] = 1;
        sum[3] = 3;

        for (int i=4; i < n+1; i++) {
            

            c[i] = sum[i-3] - c[i-3];
            b[i] = sum[i-2] - b[i-2];
            a[i] = sum[i-1] - a[i-1];
            sum[i] = a[i] + b[i] + c[i];
        }

        return sum[n];
    }
}