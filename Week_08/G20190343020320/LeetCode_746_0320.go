package g20190343020320

// 746.shi yong 最小花费爬楼梯
// https://leetcode-cn.com/problems/min-cost-climbing-stairs/

func MinCostClimbingStairs(cost []int) int {
	a, b := cost[0], cost[1]
	for i := 2; i < len(cost); i++ {
		a, b = b, minInts(a, b)+cost[i]
	}

	return minInts(a, b)
}
