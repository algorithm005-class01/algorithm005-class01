//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划


package leetcode.editor.cn;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
    }


    //leetcode submit region begin(Prohibit modificat ion and deletion)
    class Solution {

        //dp。amount相当于台阶总数。coins相当于每次可走的台阶数。这样就
        //dp方程 f(n) = min(f(n-k) for (k in a)) + 1
        public int coinChange(int[] coins, int amount) {

            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    //如果硬币面值大于i，则没有解法，小于等于i，则至少有一种解法
                    if (coin <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}