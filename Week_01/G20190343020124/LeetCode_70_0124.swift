/*
 * @lc app=leetcode.cn id=70 lang=swift
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (47.31%)
 * Likes:    740
 * Dislikes: 0
 * Total Accepted:    109.7K
 * Total Submissions: 231.7K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */

// @lc code=start
class Solution {
    // 递归会栈溢出 分治思想 分解最简单的情况 找规律
    func climbStairs(_ n: Int) -> Int {
        if n <= 2{
            return n
        }
        var tempArr = Array.init(repeating: 0, count: n+1)
        tempArr[0] = 0
        tempArr[1] = 1
        tempArr[2] = 2
            
        for i in 3...n {
        
            tempArr[i] = tempArr[i-1] + tempArr[i-2]
        }
        return tempArr[n]
    }
}
// @lc code=end

