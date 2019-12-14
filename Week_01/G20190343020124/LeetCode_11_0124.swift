/*
 * @lc app=leetcode.cn id=11 lang=swift
 *
 * [11] 盛最多水的容器
 *
 * https://leetcode-cn.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (59.59%)
 * Likes:    945
 * Dislikes: 0
 * Total Accepted:    110.8K
 * Total Submissions: 185.4K
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为
 * (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * 
 * 
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * 
 */

// @lc code=start
class Solution {
    // func maxArea(_ height: [Int]) -> Int {
    
    // // 暴力解法 超时
    //     var maxArea = 0
    //     for i in 0..<height.count {
            
    //         for j in i..<height.count {
                
    //             maxArea = max(maxArea, (j-i) * min(height[i], height[j]))
    //         }
    //     }
        
    //     return maxArea
    // }
    func maxArea(_ height: [Int]) -> Int {
    
        var maxArea = 0
        
        var i = 0, j = height.count - 1
        while i < j {
            maxArea = max(maxArea, (j-i) * min(height[i], height[j]))
            
            height[i] < height[j] ? (i+=1) : (j-=1)
        }
        
        return maxArea
    }
    
}
// @lc code=end

