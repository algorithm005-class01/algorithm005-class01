package main.leetcode_solutions.greedy;

/**
 * @author wenzhuang
 * @date 2019/12/29
 *
 * 买卖股票问题2：多次交易
 */
public class T122_BestTimeToBuyAndSellStockII {
    /**
     * 贪心解法
     * 只要下一天的股价高于当天，就在当天买入，下一天卖出
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++){
            if (prices[i + 1] > prices[i]){
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }
}
