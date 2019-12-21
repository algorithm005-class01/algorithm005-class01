package g20190343020320

// 189.旋转数组
// https://leetcode-cn.com/problems/rotate-array/
func Rotate(nums []int, k int) {
	count, start, now, l := 0, 0, 0, len(nums)
	k %= l
	if k < 1 {
		return
	}
	for count < l {
		start, now = now, (now-k+l)%l
		for start != now {
			next := (now - k + l) % l
			nums[now], nums[next], now = nums[next], nums[now], next
			count++
		}
		count++
		now++
	}
}
