/*
 * @lc app=leetcode.cn id=26 lang=swift
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
//方法一: 双指针解法
//双指针解法奏效的前提是: 假定数组 nums 已经被排序了, 如果未被排序, 输出结果不正确
//给定 nums = [0,0,1,1,2,2,3,6]
//i = 0, j = 1 时, nums = [0,0,1,1,2,2,3,6]
//i = 0, j = 2 时, nums = [0,1,1,1,2,2,3,6]
//i = 1, j = 3 时, nums = [0,1,1,1,2,2,3,6]
//i = 1, j = 4 时, nums = [0,1,2,1,2,2,3,6]
//i = 2, j = 5 时, nums = [0,1,2,1,2,2,3,6]
//i = 2, j = 6 时, nums = [0,1,2,3,2,2,3,6]
//i = 3, j = 7 时, nums = [0,1,2,3,6,2,3,6]
func removeDuplicates(_ nums : inout [Int]) -> Int{
    if nums.count == 0 {
        return 0
    }
    var i  = 0

    for j in 1..<nums.count {
        if(nums[j] != nums[i]){
            i = i+1;
            nums[i] = nums[j]
        }
    }
    print(nums[0...i])
    return (i + 1)
}

//方法二:利用Swift的Set 特性
//通过Set 过滤重复项, 再返回给数组
//此种方法比方法一耗时10ms
//func removeDuplicates(_ nums : inout [Int]) -> Int{
//    if nums.isEmpty {
//        return 0
//    }
//
//    let set = Set(nums) //去重
//    nums = Array(set)
//    nums.sort() //排序
//    print(nums)
//    return nums.count
//}
}
// @lc code=end

