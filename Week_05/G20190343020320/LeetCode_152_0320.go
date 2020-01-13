package g20190343020320

// 152.乘积最大子序列
// https://leetcode-cn.com/problems/maximum-product-subarray/
func MaxProduct(nums []int) int {
	max, imax, imin := -2147483648, 1, 1
	for i := 0; i < len(nums); i++ {
		if nums[i] < 0 {
			imax, imin = imin, imax
		}

		imax = intMax(nums[i]*imax, nums[i])
		imin = intMin(nums[i]*imin, nums[i])

		if imax > max {
			max = imax
		}
	}
	return max
}

func max152(a, b int) int {
	if a > b {
		return a
	}
	return b
}
