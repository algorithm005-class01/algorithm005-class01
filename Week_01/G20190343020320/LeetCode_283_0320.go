package g20190343020320

// 283.移动零
// https://leetcode-cn.com/problems/move-zeroes/
func MoveZeroer(nums []int) {
	pointer := 0
	for k, n := range nums {
		if n != 0 {
			nums[k], nums[pointer] = 0, nums[k]
			pointer++
		}
	}
}
