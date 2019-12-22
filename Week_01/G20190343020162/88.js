// https://leetcode-cn.com/problems/merge-sorted-array/
/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */

// 选取中两个数组，合并后排序
// 用了filter之后不行，所以抄了题解中的答案
var merge = function(nums1, m, nums2, n) {
    nums1.splice(m,nums1.length - m)
    nums2.splice(n,nums2.length - n)    
    Object.assign(nums1,[...nums1,...nums2].sort((a,b) => a - b))
};