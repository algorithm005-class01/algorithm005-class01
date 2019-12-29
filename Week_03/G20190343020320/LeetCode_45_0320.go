package g20190343020320

// 45.跳跃游戏 2
// https://leetcode-cn.com/problems/jump-game-ii/

//反向跳
func Jump(nums []int) int {
	l := len(nums)
	if l == 0 || l == 1 {
		return 0
	}
	for i := l - 1; i >= 0; i-- {
		if nums[i]+i >= l-1 {
			nums[i] = 1
		} else {
			min := l
			for j := 0; j < nums[i]; j++ {
				if min > nums[i+j+1] {
					min = nums[i+j+1]
				}
			}
			nums[i] = min + 1
		}
	}
	return nums[0]
}

// 正向跳
func Jump3(nums []int) int {
	if len(nums) < 2 {
		return 0
	}
	end := nums[0]
	max := end
	step := 0
	for i := 0; i < len(nums)-1; i++ {
		if nums[i]+i > max {
			max = nums[i] + i
		}
		if i == end {
			end = max
			step++
		}
	}

	return step + 1
}
