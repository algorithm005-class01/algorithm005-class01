package main

// Given an array nums, write a function to move all 0's to the end of it 
// while maintaining the relative order of the non-zero elements.

import (
	"testing"
)


func moveZeroes(nums []int)  {
    length := len(nums)
    j := 0
    for i := 0; i < length; i++ {
        if nums[i] != 0 {
            nums[j] = nums[i]
            j++
        }
    }
    for j < length  {
        nums[j] = 0
        j++
    }
}

func moveZeroes_v1(nums []int)  {
    pos:= 0
    for i := 0; i < len(nums); i++ {
        if nums[i] != 0 {
            nums[pos], nums[i] = nums[i], nums[pos]
            pos++
        }
    }
}

func isEqual(a []int, b []int) bool {
    length := len(a)
    if length != len(b) {
        return false
    }
    for i := 0; i < length; i++ {
        if a[i] != b[i] {
            return false
        }
    }
    return true
}

func assertEqual(t *testing.T, a bool, err string) {
	if !a {
		t.Errorf(err)
	}
}


func TestSolution(t *testing.T) {
    nums := []int{0, 1, 0, 3, 12}
    output := []int{1, 3, 12, 0, 0}
    moveZeroes(nums)
    assertEqual(t, isEqual(nums, output), "array is not equal")
}

func TestSolution_v1(t *testing.T) {
    nums := []int{0, 1, 0, 3, 12}
    output := []int{1, 3, 12, 0, 0}
    moveZeroes_v1(nums)
    assertEqual(t, isEqual(nums, output), "array is not equal")
}

