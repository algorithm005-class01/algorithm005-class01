package g20190343020320

// 860.柠檬水找零
// https://leetcode-cn.com/problems/lemonade-change/
func LemonadeChange(bills []int) bool {
	coins := [2]int{}
	for _, v := range bills {
		if v == 5 {
			coins[0]++
			continue
		}

		if coins[0] == 0 {
			return false
		}

		if v == 10 {
			coins[0]--
			coins[1]++
			continue
		}

		if coins[1] != 0 && coins[0] != 0 {
			coins[1]--
			coins[0]--
			continue
		}

		if coins[0] < 3 {
			return false
		}

		coins[0] -= 3
	}

	return true
}

// 代码优化
func LemonadeChange2(bills []int) bool {
	five, ten := 0, 0
	for _, v := range bills {
		if v == 5 {
			five++
		} else if v == 10 {
			five--
			ten++
		} else if ten == 0 {
			five -= 3
		} else {
			five--
			ten--
		}

		if five < 0 {
			return false
		}
	}

	return true
}
