package g20190343020320

// 338.比特位计算
// https://leetcode-cn.com/problems/counting-bits/

// 方法1
// 去掉了最高位的1
func CountBits_1(num int) []int {
	all := make([]int, num+1)
	var k uint = 0
	for i, j := 1, 0; i < num+1; i, j = i+1, j+1 {
		if i == (1 << k) {
			j = 0
			k++
		}
		all[i] = all[j] + 1
	}
	return all
}

// 方法1优化
func CountBits_1_2(num int) []int {
	all := make([]int, num+1)
	for i, k := 1, 1; i < num+1; i++ {
		if i == k {
			k <<= 1
		}
		all[i] = all[i-k>>1] + 1
	}
	return all
}

// 方法2
// 去掉了最低位的1
func CountBits_2(num int) []int {
	all := make([]int, num+1)
	for i := 1; i < num+1; i++ {
		all[i] = all[i&(i-1)] + 1
	}
	return all
}
