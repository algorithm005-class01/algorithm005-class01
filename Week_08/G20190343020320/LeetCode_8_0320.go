package g20190343020320

// 8.字符串转整型（atoi）
// https://leetcode-cn.com/problems/string-to-integer-atoi/

func myAtoi(str string) int {
	reInt, key, isD := 0, false, false
	for i := 0; i < len(str); i++ {
		if !key && str[i] == ' ' {
			continue
		}

		if !key && (str[i] == '-' || str[i] == '+') {
			isD, key = str[i] == '-', true
			continue
		}

		if !key {
			key = true
		}

		k := str[i] - '0'
		if 0 <= k && k <= 9 {
			reInt = reInt*10 + int(k)
			if reInt >= 2147483648 {
				reInt = 2147483648
				if !isD {
					reInt--
				}
				break
			}
		} else {
			break
		}
	}

	if isD {
		return -reInt
	}
	return reInt
}
