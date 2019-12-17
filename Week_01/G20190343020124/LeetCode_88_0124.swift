/*
 * @lc app=leetcode.cn id=88 lang=swift
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (45.86%)
 * Likes:    358
 * Dislikes: 0
 * Total Accepted:    90.1K
 * Total Submissions: 196.4K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 说明:
 * 
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 
 * 
 * 示例:
 * 
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 */

// @lc code=start
class Solution {
    // 尾指针  
    func merge1(_ nums1: inout [Int], _ m: Int, _ nums2: [Int], _ n: Int) {
        if (m == 0) {
            nums1 = nums2
            return
        }
        
        var i = m - 1, j = n - 1, total = m+n-1
        while i >= 0 && j >= 0 {
            if (nums1[i] > nums2[j]) {
                nums1[total] = nums1[i];
                i-=1
            } else {
                nums1[total] = nums2[j]
                j-=1
            }
            total -= 1
        }
        
        while j >= 0 {
            nums1[total] = nums2[j]
            total-=1;
            j-=1
        }
    }

        func merge(_ nums1: inout [Int], _ m: Int, _ nums2: [Int], _ n: Int) {
        var nums3 = [Int]()
        var i = 0, j = 0
        while i<m && j<n {
            if (nums1[i] < nums2[j]) {
                nums3.append(nums1[i])
                i+=1
            } else {
                nums3.append(nums2[j])
                j+=1
            }
        }
        if (i < m) {
            nums3.append(contentsOf: nums1[i..<m])
        }
        if (j < n) {
            nums3.append(contentsOf: nums2[j..<n])
        }
        nums1 = nums3
    }
}
// @lc code=end

