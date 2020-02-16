package g20190343020320

// 709.转换成小写字母
// https://leetcode-cn.com/problems/to-lower-case/

func ToLowerCase_709(str string) string {
	res := make([]byte, len(str))
	for i := 0; i < len(str); i++ {
		s := str[i]
		if 'A' <= s && s <= 'Z' {
			s = s - 'A' + 'a'
		}
		res[i] = s
	}
	return string(res)
}
