/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
var merge = function(nums1, m, nums2, n) {
    // 由于 nums1 数组大小足够大，可以放下 m + n 个元素，选择从后往前遍历添加元素
    // 设置三个指针
    let p = m + n - 1,
        p1 = m - 1,
        p2 = m - 2;
    while (p1 >= 0 && p2 >= 0)
        nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];

    // 如果 p2 >0 代表 nums2 还有剩余元素，将其继续添加到 nums1 中
    while (p2 >= 0) nums1[p--] = nums2[p2--];
};
