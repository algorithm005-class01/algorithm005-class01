package main

import (
    "sort"
	"fmt"
	"testing"
    "reflect"
)

func threeSum(nums []int) [][]int {
    sort.Ints(nums)
    result := make([][]int, 0)
    for i := 0; i < len(nums) - 2; i++ {
        start, end := i + 1, len(nums) - 1
        for start < end {
            sum := nums[i] + nums[start] + nums[end]
            if sum == 0 {
                result = append(result, []int{nums[i], nums[start], nums[end]})
                break
            } else if sum < 0 {
                start++
            } else {
                end--
            }
        }
    }
    return result
}

func print(a [][]int) {
	fmt.Print("[")
	for i := 0; i < len(a); i++ {
		fmt.Print("[")
		for j := 0; j < len(a[i]); j++ {
			fmt.Print(a[i][j], " ")
		}
		fmt.Print("]")
	}
	fmt.Println("]")
}

func isEqual(a [][]int, b [][]int) bool {
	length := len(a)
	if length != len(b) {
		return false
	}
	for i := 0; i < length; i++ {
        if !isIn(a[i], b) {
            return false
        }
	}
	return true
}

func isIn(a []int, b [][]int) bool {
    for i := 0; i < len(b); i++ {
        if reflect.DeepEqual(a, b[i]) {
            return true
        }
    }
    return false
}




func assertEqual(t *testing.T, a bool) {
	if !a {
		t.Errorf("Not Equal. ")
	}
}



func TestTree(t *testing.T) {
	input := []int{-1, 0, 1, 2, -1, -4}
    result := threeSum(input)
    output := make([][]int, 2, 2)
    output[0] = []int{-1, 0, 1}
    output[1] = []int{-1, -1, 2}
	assertEqual(t, isEqual(output, result))
}
