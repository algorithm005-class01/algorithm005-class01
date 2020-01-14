package g20190343020320

// 121.买卖股票的最佳时机
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
func MaxProfit_121(prices []int) (max int) {
	if len(prices) < 2 {
		return
	}
	min := prices[0]
	for i := 1; i < len(prices); i++ {
		if prices[i] < min {
			min = prices[i]
			continue
		}
		max = intMax(prices[i]-min, max)
	}
	return
}
