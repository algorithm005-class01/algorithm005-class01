/*
 * @lc app=leetcode.cn id=88 lang=javascript
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function (nums1, len1, nums2, len2) {
    //遍历，数组1+数组2的长度 , 然后列出各种条件
    //1.nums2[len2 - 1] > nums1[len1 - 1]
    //2.nums2[len2 - 1] <= nums1[len1 - 1]
    //3.num1排完
    //4.num2排完
    for (let i = len1 + len2 - 1; i >= 0; i--) {
        if (len1 > 0 && len2 > 0) {
            //
            if (nums2[len2 - 1] > nums1[len1 - 1]) {
                nums1[i] = nums2[len2 - 1];
                len2--;
            } else {
                nums1[i] = nums1[len1 - 1];
                len1--;
            }
        } else if (len1 > 0) {
            nums1[i] = nums1[len1 - 1];
            len1--;
        } else if (len2 > 0) {
            nums1[i] = nums2[len2 - 1];
            len2--;
        }
    }

};
// @lc code=end