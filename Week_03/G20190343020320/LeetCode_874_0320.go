package g20190343020320

// 874.模拟行走机器人
// https://leetcode-cn.com/problems/walking-robot-simulation/

// 暴力法
func RobotSim(commands []int, obstacles [][]int) int {
	yAxis, xAxis := []int{1, 0, -1, 0}, []int{0, 1, 0, -1}
	forward, x, y := 0, 0, 0
	maxArea := 0
	for _, v := range commands {
		if v == -1 {
			forward = (forward + 1) % 4
		} else if v == -2 {
			forward = (forward + 3) % 4
		} else {
			xcache, ycache, cacheBtn := 0, 0, false
			for _, o := range obstacles {
				if o[0] == x {
					if (y > o[1] && y+yAxis[forward]*v <= o[1]) || (y < o[1] && y+yAxis[forward]*v >= o[1]) {
						ytest := o[1] - yAxis[forward]
						if !cacheBtn || ytest*yAxis[forward] < ycache*yAxis[forward] {
							cacheBtn = true
							ycache = ytest
						}
					}
				} else if o[1] == y {
					if (x > o[0] && x+xAxis[forward]*v <= o[0]) || (x < o[0] && x+xAxis[forward]*v >= o[0]) {
						xtest := o[0] - xAxis[forward]
						if !cacheBtn || xtest*xAxis[forward] < xcache*xAxis[forward] {
							cacheBtn = true
							xcache = xtest
						}
					}
				}
			}

			if !cacheBtn {
				y += yAxis[forward] * v
				x += xAxis[forward] * v
			} else {
				if xcache != 0 {
					x = xcache
				}
				if ycache != 0 {
					y = ycache
				}
			}
		}

		area := (x * x) + (y * y)
		if maxArea < area {
			maxArea = area
		}
	}

	return maxArea
}

// 根据线上题解优化的方案
func robotSim(commands []int, obstacles [][]int) int {
	yAxis, xAxis := []int{1, 0, -1, 0}, []int{0, 1, 0, -1}
	forward, x, y := 0, 0, 0
	maxArea := 0

	xMap, yMap := make(map[int][]int), make(map[int][]int)
	for _, o := range obstacles {
		xMap[o[0]], yMap[o[1]] = append(xMap[o[0]], o[1]), append(yMap[o[1]], o[0])
	}

	for _, v := range commands {
		if v == -1 {
			forward = (forward + 1) % 4
		} else if v == -2 {
			forward = (forward + 3) % 4
		} else {
			xcache, ycache, cacheBtn := 0, 0, false

			if xAxis[forward] != 0 {
				for _, xm := range yMap[y] {
					if (x > xm && x+xAxis[forward]*v <= xm) || (x < xm && x+xAxis[forward]*v >= xm) {
						xtest := xm - xAxis[forward]
						if !cacheBtn || xtest*xAxis[forward] < xcache*xAxis[forward] {
							cacheBtn = true
							xcache = xtest
						}
					}
				}
			} else {
				for _, ym := range xMap[x] {
					if (y > ym && y+yAxis[forward]*v <= ym) || (y < ym && y+yAxis[forward]*v >= ym) {
						ytest := ym - yAxis[forward]
						if !cacheBtn || ytest*yAxis[forward] < ycache*yAxis[forward] {
							cacheBtn = true
							ycache = ytest
						}
					}
				}
			}

			if !cacheBtn {
				y += yAxis[forward] * v
				x += xAxis[forward] * v
			} else {
				if xcache != 0 {
					x = xcache
				}
				if ycache != 0 {
					y = ycache
				}
			}
		}

		area := (x * x) + (y * y)
		if maxArea < area {
			maxArea = area
		}
	}

	return maxArea
}

// 线上题解
const BaseNum int = 100000

type MovePoint struct {
	x int
	y int
	v Vector
}

type Vector struct {
	x int
	y int
}

func (mp *MovePoint) change(cmd int) {
	v := &mp.v
	if v.x != 0 { // x轴
		if cmd == -1 {
			v.y = v.x * -1
		} else if cmd == -2 {
			v.y = v.x
		}
		v.x = 0
	} else { // y轴
		if cmd == -1 {
			v.x = v.y
		} else if cmd == -2 {
			v.x = v.y * -1
		}
		v.y = 0
	}
}

func (mp *MovePoint) getPv() int {
	return mp.x*BaseNum + mp.y
}

func (mp *MovePoint) move(pMap map[int]int, distance int) {
	vector := mp.v
	xx := mp.x
	yy := mp.y
	for i := 1; i <= distance; i++ {
		key := (xx+vector.x*i)*BaseNum + (yy + vector.y*i)
		_, ok := pMap[key]
		if ok {
			//fmt.Println("撞到了")
			break
		}
		mp.x += vector.x
		mp.y += vector.y
	}

}

func RobotSim2(commands []int, obstacles [][]int) int {
	x := 0
	y := 0
	position := MovePoint{x, y, Vector{0, 1}}
	pMap := make(map[int]int)
	for e := range obstacles {
		tmp := obstacles[e]
		key := tmp[0]*BaseNum + tmp[1]
		pMap[key] = 0
	}
	max := 0
	for _, cmd := range commands {
		if cmd > 0 {
			position.move(pMap, cmd)
			tmpR := position.x*position.x + position.y*position.y
			if max < tmpR {
				max = tmpR
			}
		} else if cmd < 0 {
			position.change(cmd)
			//fmt.Println(" 转向之后", position.v.x, position.v.y)
		}
	}
	//fmt.Println("x, y", position.x, position.y )

	return max
}
