package g20190343020320

// 433.最小基因变化
// https://leetcode-cn.com/problems/minimum-genetic-mutation/
func MinMutation(start string, end string, bank []string) int {

	if start == "" || end == "" || len(bank) == 0 {
		return -1
	}

	if i := validStep(start, end); i < 2 {
		return i
	}

	key := -1
	for k, v := range bank {
		if end == v {
			key = k
			break
		}
	}

	if key == -1 {
		return -1
	}
	return loopStep(start, end, bank)
}

func loopStep(start, end string, bank []string) int {
	queue := []string{end, ""}
	level := 1
	visit := make([]int, len(bank))

	for len(queue) > 1 {
		if e := queue[0]; e == "" {
			queue = append(queue, "")
			level++
		} else {
			for k, v := range bank {
				if visit[k] == 1 || v == end {
					continue
				}

				if i := validStep(e, v); i == 1 || i == 0 {
					if validStep(start, v) == 1 {
						return level + i
					}
					visit[k] = 1
					queue = append(queue, v)
				}
			}
		}
		queue = queue[1:]
	}
	return -1
}

func validStep(start, end string) (re int) {
	for k, v := range end {
		if v != rune(start[k]) {
			if re++; re > 1 {
				return
			}
		}
	}
	return
}
