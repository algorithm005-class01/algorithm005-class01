package g20190343020320

// 78.子集
// https://leetcode-cn.com/problems/subsets/
func Subsets(nums []int) [][]int {
	subArr78 = [][]int{[]int{}}
	bsubsets(nums, []int{})
	return subArr78
}

var subArr78 [][]int

// 太复杂，逻辑不清晰，需要改写
func bsubsets(nums, sub []int) {
	for i := 0; i < len(nums); i++ {
		subPlus, next := []int{}, []int{}
		subPlus = append(append(subPlus, sub...), nums[i])
		subArr78 = append(subArr78, subPlus)
		next = append(next, nums[i+1:]...)
		bsubsets(next, subPlus)
	}
}
