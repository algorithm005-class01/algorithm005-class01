package g20190343020320

// 53.最大子序和
// https://leetcode-cn.com/problems/maximum-subarray/

// 贪心法
func MaxSubArray(nums []int) int {
	if len(nums) == 0 {
		return -2147483648
	}
	max, cache := nums[0], nums[0]
	for i := 1; i < len(nums); i++ {
		if nums[i] > cache+nums[i] {
			cache = nums[i]
		} else {
			cache += nums[i]
		}

		if cache > max {
			max = cache
		}
	}

	return max
}
