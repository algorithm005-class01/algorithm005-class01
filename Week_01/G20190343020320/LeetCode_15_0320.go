package g20190343020320

// 15.三数之和
// https://leetcode-cn.com/problems/3sum/
func ThreeSum(nums []int) (re [][]int) {
	if len(nums) < 3 {
		return
	}
	// 排序
	quickSort(nums)

	// 寻找
	for i := 0; nums[i] <= 0 && i < len(nums)-2; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		p, q := i+1, len(nums)-1
		for p < q {
			ze := 0 - nums[p] - nums[q]
			if nums[i] == ze && (p-1 == i || nums[p-1] != nums[p]) {
				re = append(re, []int{nums[i], nums[p], nums[q]})
			}

			if nums[i] > ze {
				q--
			} else {
				p++
			}
		}
	}

	return
}

func quickSort(nums []int) {
	if len(nums) < 2 {
		return
	}

	j := 1
	for i := 1; i < len(nums); i++ {
		if nums[0] >= nums[i] {
			nums[i], nums[j] = nums[j], nums[i]
			j++
		}
	}
	nums[0], nums[j-1] = nums[j-1], nums[0]

	quickSort(nums[:j-1])
	quickSort(nums[j:])
}
