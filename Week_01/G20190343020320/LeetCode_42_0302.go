package g20190343020320

// 42.接雨水
// https://leetcode.com/problems/trapping-rain-water/
func Trap(height []int) int {
	if len(height) < 1 {
		return 0
	}
	p, q := 0, len(height)-1
	hp, hq := p, q
	allArea, zArea := 0, 0
	for p < q {
		if height[p] < height[q] {
			zArea += height[p]
			p++
			if height[p] > height[hp] {
				allArea += height[hp] * (p - hp)
				hp = p
			}
		} else {
			zArea += height[q]
			q--
			if height[q] > height[hq] {
				allArea += height[hq] * (hq - q)
				hq = q
			}
		}
	}

	allArea += height[hp] * (hq - hp)
	return allArea - zArea
}
