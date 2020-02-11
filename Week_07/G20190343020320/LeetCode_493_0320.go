package g20190343020320

// 493.翻转对
// https://leetcode-cn.com/problems/reverse-pairs/

func ReversePairs(nums []int) int {
	Count_493 = 0
	MergeSort_493(nums, 0, len(nums)-1)
	return Count_493
}

var Count_493 int

func MergeSort_493(nums []int, left, right int) {
	if left >= right {
		return
	}

	mid := (left + right) >> 1
	MergeSort_493(nums, left, mid)
	MergeSort_493(nums, mid+1, right)
	Merge_493(nums, left, mid, right)
}

func Merge_493(nums []int, left, mid, right int) {
	temp := make([]int, right-left+1)

	idx, i, j := 0, left, mid+1
	// f := mid+1

	for a, b := i, j; a <= mid; a++ {
		for ; b <= right && nums[a] <= 2*nums[b]; b++ {
		}
		Count_493 += right - b + 1
	}

	for i <= mid && j <= right {
		if nums[i] >= nums[j] {
			// if nums[i] > 2*nums[f] {
			// 	Count_493 += right - f + 1
			// } else if f < right {
			// 	f++
			// 	continue
			// }

			temp[idx] = nums[i]
			i++
		} else {
			temp[idx] = nums[j]
			j++
		}
		idx++
	}

	for ; i <= mid; i, idx = i+1, idx+1 {
		temp[idx] = nums[i]
	}
	for ; j <= right; j, idx = j+1, idx+1 {
		temp[idx] = nums[j]
	}

	for k, v := range temp {
		nums[left+k] = v
	}
}
