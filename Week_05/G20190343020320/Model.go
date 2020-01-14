package g20190343020320

func intMax(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func intMin(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func intMinTh(a, b, c int) int {
	return intMin(intMin(a, b), c)
}
