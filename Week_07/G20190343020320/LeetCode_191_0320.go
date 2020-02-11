package g20190343020320

// 191.位1的个数
// https://leetcode-cn.com/problems/number-of-1-bits/

func HammingWeight(num uint32) int {
	count := 0
	for num != 0 {
		if num&1 == 1 {
			count++
		}
		num >>= 1
	}

	return count
}

// 解法2
func HammingWeight2(num uint32) int {
	count := 0
	for num != 0 {
		count += int(num & 1)
		num >>= 1
	}

	return count
}
