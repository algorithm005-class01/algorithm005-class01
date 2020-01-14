package com.miui.testbyxzl;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCodde_70_0010 {

    // class Solution {
//     public int climbStairs(int n) {
//          int memo[] = new int[n + 1];
//         return sub(0, n, memo);
//     }

//     private int sub(int i ,int n, int[] sum){
//         if (i > n) {
//             return 0;
//         }
//         if (i == n) {
//             return 1;
//         }
//         if(sum[i] == 0){
//             sum[i] =  sub(i + 1, n, sum) + sub(i + 2, n, sum);
//         }

//         return sum[i];
//     }
// }


    public class Solution {
        public int climbStairs(int n) {
            if (n <= 2) {
                return n;
            }

            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];
        }
    }


// public class Solution {
//     public int climbStairs(int n) {
//         int memo[] = new int[n + 1];
//         return climb_Stairs(0, n, memo);
//     }
//     public int climb_Stairs(int i, int n, int memo[]) {
//         if (i > n) {
//             return 0;
//         }
//         if (i == n) {
//             return 1;
//         }
//         if (memo[i] > 0) {
//             return memo[i];
//         }
//         memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
//         return memo[i];
//     }

// }

}
