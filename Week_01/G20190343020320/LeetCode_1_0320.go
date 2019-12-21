package g20190343020320

// 1.两数之和
// https://leetcode-cn.com/problems/two-sum/
func TwoSum(nums []int, target int) []int {
	hashmap := make(map[int]int)
	for k, v := range nums {
		if hashmap[v] != 0 {
			return []int{hashmap[v] - 1, k}
		}
		hashmap[target-v] = k + 1
	}
	return []int{}
}
