package g20190343020320

// 771.宝石与石头
// https://leetcode-cn.com/problems/jewels-and-stones/

func NumJewelsInStones(J string, S string) int {
	arr, count := make([]bool, 52), 0
	for _, j := range J {
		nums := j - 'a'
		if nums < 0 {
			nums = j - 'A' + 26
		}

		arr[nums] = true
	}

	for _, s := range S {
		nums := s - 'a'
		if nums < 0 {
			nums = s - 'A' + 26
		}

		if arr[nums] {
			count++
		}
	}

	return count
}
