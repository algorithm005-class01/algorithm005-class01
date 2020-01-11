package g20190343020320

// 50.Pow(x, n)
// https://leetcode-cn.com/problems/powx-n/solution/
func MyPow(x float64, n int) float64 {
	if n == 0 {
		return 1
	}
	if n%2 != 0 {
		a, b := x, -1
		if n < 0 {
			a, b = 1/x, 1
		}
		return a * MyPow(x, n+b)
	}
	return MyPow(x*x, n/2)
}

// func MyPow2(x float64, n int) float64 {

// }
