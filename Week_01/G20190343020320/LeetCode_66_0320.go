package g20190343020320

// 66.加一
// https://leetcode-cn.com/problems/plus-one/
func PlusOne(digits []int) []int {
	addOne := true
	for i := len(digits) - 1; addOne && i > -1; i-- {
		addOne = false
		if digits[i] == 9 {
			digits[i] = 0
			addOne = true
		} else {
			digits[i]++
			return digits
		}
	}

	return append([]int{1}, digits...)
}

// 调整判断顺序，1.精简掉进位标记，2.避免数组群移
func PlusOne2(digits []int) []int {
	for i := len(digits) - 1; i > -1; i-- {
		if digits[i] < 9 {
			digits[i]++
			return digits
		}
		digits[i] = 0
	}

	digits[0] = 1
	return append(digits, 0)
}
