package g20190343020320

// 213.打家劫舍2
// https://leetcode-cn.com/problems/house-robber-ii/
func Rob_213(nums []int) int {
	l := len(nums)
	if l == 0 {
		return 0
	}

	if l == 1 {
		return nums[0]
	}

	if l == 2 {
		return intMax(nums[0], nums[1])
	}

	a, b, c := 0, nums[0], nums[1]
	d, e, f := 0, nums[1], nums[2]
	for i := 2; i < l; i++ {
		if i < l-1 {
			a, b, c = b, c, nums[i]+intMax(a, b)
		}
		if i > 2 {
			d, e, f = e, f, nums[i]+intMax(d, e)
		}
	}

	return intMax(intMax(b, c), intMax(e, f))
}

// 修改：两次遍历
// 优点：方便拓展，逻辑清晰
func Rob_213_2(nums []int) int {
	l := len(nums)
	if l == 0 {
		return 0
	}

	if l == 1 {
		return nums[0]
	}

	if l == 2 {
		return intMax(nums[0], nums[1])
	}

	return intMax(myRob_213_2(nums[1:]), myRob_213_2(nums[:l-1]))
}

func myRob_213_2(nums []int) int {
	a, b, c := 0, nums[0], nums[1]
	for i := 2; i < len(nums); i++ {
		a, b, c = b, c, nums[i]+intMax(a, b)
	}
	return intMax(b, c)
}
