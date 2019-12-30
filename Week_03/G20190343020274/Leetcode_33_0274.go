package main

import (
    "testing"
    "fmt"
)

func search(nums []int, target int) int {
    low, high := 0, len(nums) - 1
    for low <= high {
        mid := int(low + (high - low)/2)
        if nums[mid] == target {
            return mid
        } else if nums[low] <= nums[mid] {
            if nums[low] <= target && target < nums[mid] {
                high = mid - 1
            } else {
                low = mid + 1
            }
        } else {
            if nums[mid] < target && target <= nums[high] {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
    }   
    return -1 
}

func assertTrue(t *testing.T, r bool) {
    if !r {
        t.Errorf("not equal")
    }
}

func TestSolution_recursion(t *testing.T) {
    nums := []int{4, 5, 6, 7, 0, 1, 2}
    assertTrue(t, search(nums, 0) == 4)
    assertTrue(t, search(nums, 3) == -1)
}
