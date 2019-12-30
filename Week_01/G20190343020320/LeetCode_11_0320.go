package g20190343020320

func MaxArea(height []int) (max int) {
	for p, q := 0, len(height)-1; p < q; {
		less, area := height[p], q-p
		if less > height[q] {
			less = height[q]
			q--
		} else {
			p++
		}

		area *= less
		if max < area {
			max = area
		}
	}
	return max
}
