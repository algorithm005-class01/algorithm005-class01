package main

func removeDuplicates(nums []int) int {
	var h = make(map[int]struct{})
	var removeCount int
	var length = len(nums)

	for id,num := range nums{
		if _,ok := h[num]; ok {
			removeCount++
			continue
		}

		if removeCount > 0 {
			nums[id-removeCount] = num
		}
		h[num] = struct{}{}
	}

	nums = nums[:length-removeCount]

	return length-removeCount
}
