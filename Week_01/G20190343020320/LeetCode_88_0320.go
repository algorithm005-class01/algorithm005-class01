package g20190343020320

// 88.合并两个有序数组
// https://leetcode-cn.com/problems/merge-sorted-array/
func MergeTwoArray(nums1 []int, m int, nums2 []int, n int) {
	if m < 1 {
		copy(nums1, nums2)
		return
	}
	for i := m + n - 1; i > -1; i-- {
		if m > 0 && (n <= 0 || nums1[m-1] > nums2[n-1]) {
			nums1[i] = nums1[m-1]
			m--
		} else if n > 0 {
			nums1[i] = nums2[n-1]
			n--
		}
	}
}

// 参考解法优化: 当 nums2 先排序完成，可以少循环 nums1 前段
func MergeTwoArray2(nums1 []int, m int, nums2 []int, n int) {
	for n > 0 {
		if m != 0 && nums1[m-1] > nums2[n-1] {
			nums1[m+n-1] = nums1[m-1]
			m--
		} else {
			nums1[m+n-1] = nums2[n-1]
			n--
		}
	}
}
