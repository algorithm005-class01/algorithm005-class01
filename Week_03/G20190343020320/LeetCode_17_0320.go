package g20190343020320

// 17.电话号码的字母组合
// https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/

// 循环排列
func LetterCombinations(digits string) []string {
	maps := map[rune]string{
		'2': "abc",
		'3': "def",
		'4': "ghi",
		'5': "jkl",
		'6': "mno",
		'7': "pqrs",
		'8': "tuv",
		'9': "wxyz",
	}

	allString := []string{}
	for _, v := range digits {
		allString = letterCombSting(allString, maps[v])
	}

	return allString
}

func letterCombSting(comb []string, elemate string) []string {
	combString := []string{}
	for _, vE := range elemate {
		if len(comb) == 0 {
			combString = append(combString, string(vE))
			continue
		}
		for _, vC := range comb {
			combString = append(combString, vC+string(vE))
		}
	}
	return combString
}
