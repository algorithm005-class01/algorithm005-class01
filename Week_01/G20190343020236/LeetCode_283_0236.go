package main

func main() {
}

func moveZeroes(nums []int) {
	l := len(nums)
	i, j := 0, 0

	for j < l {
		if nums[j] != 0 {
			nums[i] = nums[j]
			i++
		}
		j++
	}

	// i 以前的位置上，保存了nums中所有的非零数
	// 只要把 nums[i:] 都置零，即可
	for i < l {
		nums[i] = 0
		i++
	}
}

