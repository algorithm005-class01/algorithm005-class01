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

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //暴力法，要看到树分解的图才能想出来
        public int coinChange(int[] coins, int amount) {

            // 由于硬币是整数，因此组成0的方法为0
            if (amount == 0) {
                return 0;
            }
            int result = -1;
            //暴力递归。
            for (int coin : coins) {
                if (coin > amount) {
                    continue;
                }
                int sub = coinChange(coins, amount - coin);
                if (sub == -1) {
                    //如果此数无解，则计算下一个树
                    continue;
                }
                result = result == -1 ? sub : Integer.min(sub, result);
            }

            return result != -1 ? result + 1 : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}