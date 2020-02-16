package g20190343020320

// 818.赛车
// https://leetcode-cn.com/problems/race-car/

// 解法1：BFS，超时
// 优化方案：优先队列(A*)
func Racecar_1(target int) int {
	queue, temp, step := [][]int{[]int{0, 1}}, [][]int{}, 0

	for len(queue) > 0 {
		temp = [][]int{}

		for _, v := range queue {
			if v[0] == target {
				return step
			}

			temp = append(temp, []int{v[0] + v[1], v[1] * 2})
			if v[1] > 0 {
				temp = append(temp, []int{v[0], -1})
			} else {
				temp = append(temp, []int{v[0], 1})
			}
		}

		step++
		queue = temp
	}

	return -1
}

// DP解法未看明白
