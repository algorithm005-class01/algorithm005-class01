package g20190343020320

// 169.多数元素
// https://leetcode-cn.com/problems/majority-element/

// 方法一：遍历
func MajorityElement(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	maps := make(map[int]int)
	maxNum := nums[0]

	for _, v := range nums {
		maps[v]++
		if maps[v] > maps[maxNum] {
			maxNum = v
		}
	}

	return maxNum
}

// 方法二：投票法
func MajorityElement2(nums []int) int {
	var ret, count int
	for i := 0; i < len(nums); i++ {
		if count == 0 {
			ret = nums[i]
		}
		if ret == nums[i] {
			count++
		} else {
			count--
		}
	}
	return ret
}
