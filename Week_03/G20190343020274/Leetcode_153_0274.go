package main

import (
    "testing"
    "sort"
)

// T(n) = O(nlgn)
func findMin_v1(nums []int) int {
    sort.Ints(nums)
    return nums[0]
}

// T(n) = O(n)
func findMin_v2(nums []int) int {
    result := nums[0]
    for _, num := range nums {
        if result > num {
            result = num
        }
    }
    return result
}

// T(n) = O(lgn)
func findMin_v3(nums []int) int {
    low, high := 0, len(nums) - 1
    result := nums[0]
    for low <= high {
        mid := int(low + (high - low)/2)
        if nums[low] <= nums[mid] {
            if result > nums[low] {
                result = nums[low]
            }
            low = mid + 1
        } else {
            high = mid - 1
            if result > nums[mid] {
                result = nums[mid]
            }
        }   

    }   
    return result 
}

func assertTrue(t *testing.T, r bool) {
    if !r {
        t.Errorf("not equal")
    }
}

func TestSolution_recursion(t *testing.T) {
    nums := []int{4, 5, 6, 7, 0, 1, 2}
    assertTrue(t, findMin_v1(nums) == 0)
    nums = []int{4, 5, 6, 7, 0, 1, 2}
    assertTrue(t, findMin_v2(nums) == 0)
    nums = []int{4, 5, 6, 7, 0, 1, 2}
    assertTrue(t, findMin_v3(nums) == 0)
}
