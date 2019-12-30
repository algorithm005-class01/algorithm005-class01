package g20190343020320

// 55.跳跃游戏
// https://leetcode-cn.com/problems/jump-game/
func CanJump(nums []int) bool {
	end := len(nums) - 1
	if end < 0 {
		return false
	}

	for i := end; i >= 0; i-- {
		if nums[i]+i >= end {
			end = i
		}
	}

	return end == 0
}
