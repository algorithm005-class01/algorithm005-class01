package main

func maxArea(heights []int) int {
	var max,area int
	var i,j = 0,len(heights)-1
	var width,height int

	for ;i<j;{
		width = j-i
		height = heights[i]
		if heights[i] <= heights[j]{
			i++
		}else{
			height = heights[j]
			j--
		}
		area = width*height
		if area > max{
			max = area
		}
	}
	return max
}
