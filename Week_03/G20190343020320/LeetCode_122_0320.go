package g20190343020320

// 122.买卖股票的最佳时机 2
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
func MaxProfit(prices []int) int {
	if len(prices) == 0 {
		return 0
	}

	min, max, all := 0, 0, 0
	for i := 1; i < len(prices); i++ {
		if prices[i] < prices[i-1] {
			all += max
			min, max = i, 0
			continue
		}
		if max < prices[i]-prices[min] {
			max = prices[i] - prices[min]
		}
	}

	return all + max
}

// f
func MaxProfit2(prices []int) int {
	all := 0
	for i := 1; i < len(prices); i++ {
		if prices[i] > prices[i-1] {
			all += prices[i] - prices[i-1]
		}
	}
	return all
}
