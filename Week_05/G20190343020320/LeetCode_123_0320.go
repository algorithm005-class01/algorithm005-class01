package g20190343020320

// 123.买卖股票的最佳时机2
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/

// 解法1:定义，是否持有股票的情况下，卖出过多少次股票
func MaxProfit_123_1(prices []int) int {
	l := len(prices)
	if l < 2 {
		return 0
	}
	dp := make([][2][3]int, l)

	dp[0][0][0] = 0
	dp[0][1][0] = -prices[0]
	dp[0][0][1], dp[0][0][2], dp[0][1][1] = -2147483648, -2147483648, -2147483648

	for i := 1; i < l; i++ {
		// 没持有股票，且没卖过股票
		dp[i][0][0] = 0
		// 没持有股票，且只卖过一次股票
		dp[i][0][1] = intMax(dp[i-1][0][1], dp[i-1][1][0]+prices[i])
		// 没持有股票，且已经卖过了两次股票
		dp[i][0][2] = intMax(dp[i-1][0][2], dp[i-1][1][1]+prices[i])

		// 持有股票，且没有卖过股票
		dp[i][1][0] = intMax(dp[i-1][1][0], dp[i-1][0][0]-prices[i])
		// 持有股票，且卖过一次股票
		dp[i][1][1] = intMax(dp[i-1][1][1], dp[i-1][0][1]-prices[i])
		// 持有股票，且卖过两次股票（不存在情况）
		dp[i][1][2] = -2147483648
	}

	return intMax(dp[l-1][0][0], intMax(dp[l-1][0][2], dp[l-1][0][1]))
}

// 解法2:定义，将第二层状态定义为，未持股且未卖出，持股且未卖出，未持股且卖出过一次，持股且卖出过一次，卖出过两次，
func MaxProfit_123_2(prices []int) int {
	l := len(prices)
	if l < 2 {
		return 0
	}
	dp := make([][5]int, l)

	dp[0][0] = 0
	dp[0][1] = -prices[0]
	dp[0][2], dp[0][3], dp[0][4] = -2147483648, -2147483648, -2147483648

	for i := 1; i < l; i++ {
		dp[i][0] = 0
		dp[i][1] = intMax(dp[i-1][1], dp[i-1][0]-prices[i])
		dp[i][2] = intMax(dp[i-1][2], dp[i-1][1]+prices[i])
		dp[i][3] = intMax(dp[i-1][3], dp[i-1][2]-prices[i])
		dp[i][4] = intMax(dp[i-1][4], dp[i-1][3]+prices[i])
	}

	return intMax(intMax(dp[l-1][0], dp[l-1][1]), intMax(intMax(dp[l-1][2], dp[l-1][3]), dp[l-1][4]))
}

// 解法2优化空间复杂度
func MaxProfit_123_2_2(prices []int) int {
	l := len(prices)
	if l < 2 {
		return 0
	}

	// a:未持股且未卖出(可去掉，这里为保证理解顺畅保留）
	// b:持股且未卖出
	// c:未持股且卖出过一次
	// d:持股且卖出过一次
	// e:卖出过两次
	a, b, c, d, e := 0, -prices[0], -2147483648, -2147483648, -2147483648

	for i := 1; i < l; i++ {
		e = intMax(e, d+prices[i])
		d = intMax(d, c-prices[i])
		c = intMax(c, b+prices[i])
		b = intMax(b, a-prices[i])
	}

	return intMax(0, e)
}
