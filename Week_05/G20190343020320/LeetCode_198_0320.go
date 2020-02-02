package g20190343020320

// 198.打家劫舍
// https://leetcode-cn.com/problems/house-robber/
func Rob_198(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	if len(nums) == 1 {
		return nums[0]
	}

	for i := 2; i < len(nums); i++ {
		if i == 2 {
			nums[i] += nums[i-2]
		} else {
			nums[i] += intMax(nums[i-2], nums[i-3])
		}
	}

	return intMax(nums[len(nums)-1], nums[len(nums)-2])
}

// 另开新数组
func Rob_198_2(nums []int) int {

	l := len(nums)
	if l < 1 {
		return 0
	}

	cache := make([]int, l+1)
	for i := 0; i < l; i++ {
		if i < 2 {
			cache[i+1] = nums[i]
		} else {
			cache[i+1] = nums[i] + intMax(cache[i-1], cache[i-2])
		}
	}

	return intMax(cache[l], cache[l-1])
}

// 优化空间复杂度
func Rob_198_3(nums []int) int {

	l := len(nums)
	if l < 1 {
		return 0
	}
	if l < 2 {
		return nums[0]
	}

	a, b, c := 0, nums[0], nums[1]
	for i := 2; i < l; i++ {
		a, b, c = b, c, nums[i]+intMax(a, b)
	}

	return intMax(b, c)
}

// 其他人答案
func Rob_198_4(nums []int) int {

	l := len(nums)
	if l < 1 {
		return 0
	}
	if l < 2 {
		return nums[0]
	}

	a, b := 0, 0
	for i := 0; i < l; i++ {
		a, b = b, intMax(nums[i]+a, b)
	}

	return b
}
