/*
 * @lc app=leetcode.cn id=42 lang=swift
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    //双指针
func trap(_ height: [Int]) -> Int{
    var leftMax = 0, rightMax = 0
    var leftPointer = 0, rightPoint = height.count - 1
    var trappedWater = 0
    
    while leftPointer < rightPoint {
        if height[leftPointer] < height[rightPoint] {
            if height[leftPointer] > leftMax{
                leftMax = height[leftPointer]
            }else{
                trappedWater += leftMax - height[leftPointer]
            }
            leftPointer += 1
        }else{
            if height[rightPoint] > rightMax {
                rightMax = height[rightPoint]
            }else{
                trappedWater += rightMax - height[rightPoint]
            }
            rightPoint -= 1
        }
        
    }
    return trappedWater
}
}
// @lc code=end

