package g20190343020320

// 122.买卖股票的最佳时机2
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
func MaxProfit_122(prices []int) int {
	max := 0
	for i := 1; i < len(prices); i++ {
		max += intMax(prices[i]-prices[i-1], 0)
	}
	return max
}
