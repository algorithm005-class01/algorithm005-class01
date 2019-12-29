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
var merge = function(nums1, m, nums2, n) {
    //方案1 splice 时间复杂度高
    // let i = 0,j = 0
    // while(i < m && j < n) {
    //   if(nums1[i] > nums2[j]) {
    //     nums1.splice(i,0,nums2[j++])
    //     m++
    //   }
    //   i++
    // }
    // while(j < n) {
    //   nums1.splice(i++,0,nums2[j++])
    //   m++
    // }
    // nums1.length = m


    //方案2 优化时间复杂度，从后往前填代码
    // let pos1 = m - 1, pos2 = n - 1, allLen = m + n - 1
    // while(allLen >= 0 && pos1 >= 0 && pos2 >= 0) {
    //   if(nums1[pos1] > nums2[pos2]) {
    //     nums1[allLen--] = nums1[pos1--]
    //   } else {
    //     nums1[allLen--] = nums2[pos2--]
    //   }
    // }
    // while(pos2 >= 0) {
    //   nums1[allLen--] = nums2[pos2--]
    // }

    //解法3 看的题解， 题解2第二的while循环占用时间很多
    let len1 = m - 1;
    let len2 = n - 1;
    let len = m + n - 1;
    while(len1 >= 0 && len2 >= 0) {
        // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
        nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
    }
    function arrayCopy(src, srcIndex, dest, destIndex, length) {
        dest.splice(destIndex, length, ...src.slice(srcIndex, srcIndex + length));
    }
    // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
    arrayCopy(nums2, 0, nums1, 0, len2 + 1);
};
// @lc code=end

