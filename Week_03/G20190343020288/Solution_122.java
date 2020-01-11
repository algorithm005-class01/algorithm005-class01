package week_03.commit;

// 122. 买卖股票的最佳时机 II
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
public class Solution_122 {

    public static int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i])
                total += prices[i + 1] - prices[i];
        }
        return total;
    }
}
