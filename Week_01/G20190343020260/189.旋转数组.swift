/*
 * @lc app=leetcode.cn id=189 lang=swift
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
//方法一: 逆序法
//思路: 先把前n-k个z数字翻转一下, 再把后k个数字翻转一下, 最后再把整个数组翻转一下
//空间复杂度为O(1)
//1.定义 reverse 逆转方法：将数组元素反转，比如 [1,2,3,4] 逆转后变成 [4,3,2,1]
//2.对前 n - k 个元素 [1,2,3,4] 进行逆转后得到 [4,3,2,1]
//3.对后k个元素 [5,6,7] 进行逆转后得到 [7,6,5]
//4.将前后元素 [4,3,2,1,7,6,5] 逆转得到：[5,6,7,1,2,3,4]
func rotate(_ nums : inout [Int], _ k: Int){

    let terns = k % nums.count
    if(nums.isEmpty || terns == 0){
        return
    }

    let middle = nums.count - terns

    reverse(&nums, s: 0, e: middle - 1)
    reverse(&nums, s: middle, e: nums.count - 1)
    reverse(&nums, s: 0, e: nums.count - 1)
}

func reverse(_ nums : inout [Int], s: Int, e: Int){
    var s = s
    var e = e
    while s < e {
        let temp = nums[s]
        nums[s] = nums[e]
        nums[e] = temp

        s += 1
        e -= 1
    }
}

//方法二: 取余数
//比如长度为5的数组，向右旋转2步
//1，2，3，4，5
//4，5，1，2，3
// newNums[(0 + 2) % 5] = nums[0]  即新数组newNums[2] = nums[0] = 1
// newNums[(4 + 2) % 5] = nums[4]  即新数组newNums[1] = nums[4] = 5
func rotate(_ nums : inout [Int], _ k: Int){
    let terns = k % nums.count
    
    if nums.isEmpty || terns == 0 {
        return
    }
    
    var newNums = nums
    for i in 0..<nums.count {
        newNums[(i+terns) % nums.count] = nums[i]
    }
    nums = newNums
}

}
// @lc code=end

