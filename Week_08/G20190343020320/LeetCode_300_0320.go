package g20190343020320

// 300.最长上升子序列
// https://leetcode-cn.com/problems/longest-increasing-subsequence/

func LengthOfLIS(nums []int) int {
	l := len(nums)
	if l < 1 {
		return 0
	}

	dp, k := make([]int, l), 1
	dp[0] = nums[0]
	for i := 1; i < l; i++ {
		if nums[i] > dp[k-1] {
			dp[k], k = nums[i], k+1
			continue
		}
		Find_300(dp, nums[i], 0, k-1)
	}

	return k
}

func Find_300(dp []int, q, left, right int) {
	if left == right {
		dp[left] = q
		return
	}

	if mid := (left + right) >> 1; q <= dp[mid] {
		Find_300(dp, q, left, mid)
	} else {
		Find_300(dp, q, mid+1, right)
	}
}
