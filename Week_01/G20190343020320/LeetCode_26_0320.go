package g20190343020320

// 26.删除数组中的重复项
// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
func RemoveDuplicates(nums []int) int {
	point := 0
	for i := 1; i < len(nums); i++ {
		if nums[point] != nums[i] {
			point++
			nums[point] = nums[i]
		}
	}
	return point + 1
}
