package g20190343020320

// 153.寻找旋转排序数组的最小值
// https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
func FindMin(nums []int) int {
	left, right := 0, len(nums)-1
	for left < right {
		mid := (left + right) / 2
		if nums[0] <= nums[mid] && nums[mid] > nums[len(nums)-1] {
			left = mid + 1
		} else {
			right = mid
		}
	}
	return nums[left]
}
