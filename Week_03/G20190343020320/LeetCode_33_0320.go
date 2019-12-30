package g20190343020320

// 33.搜索排序数组
// https://leetcode-cn.com/problems/search-in-rotated-sorted-array/

// 二分查找还原数组法
func Search(nums []int, target int) int {
	if len(nums) == 0 {
		return -1
	}

	left, right, rotate := 0, len(nums)-1, 0
	for left < right {
		mid := (left + right) / 2
		if nums[mid] < nums[right] {
			right = mid
		} else {
			left = mid + 1
		}
	}

	renums := []int{}
	renums = append(renums, nums[right:]...)
	renums = append(renums, nums[:right]...)

	left, right, rotate = 0, len(renums)-1, right
	for left < right {
		mid := (left + right) / 2
		if renums[mid] < target {
			left = mid + 1
		} else {
			right = mid
		}
	}
	if renums[right] == target {
		return (right + rotate) % len(nums)
	}
	return -1
}

// 二分查找，有点冗长
func Search2(nums []int, target int) int {
	if len(nums) == 0 {
		return -1
	}

	left, right := 0, len(nums)-1
	for left < right {
		mid := (left + right) / 2
		if nums[mid] == target {
			return mid
		}

		// 缩减前
		// if nums[mid] < nums[right] {
		// 	if nums[mid] <= target && target <= nums[right] {
		// 		left = mid + 1
		// 	} else {
		// 		right = mid
		// 	}
		// } else {
		// 	if nums[left] <= target && target <= nums[mid] {
		// 		right = mid
		// 	} else {
		// 		left = mid + 1
		// 	}
		// }

		if nums[mid] < nums[right] && (nums[mid] <= target && target <= nums[right]) ||
			nums[mid] >= nums[left] && (nums[left] > target || target > nums[mid]) {
			left = mid + 1
		} else {
			right = mid
		}
	}

	if nums[left] == target {
		return left
	}
	return -1
}
