/** 解法一：暴力法
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    const size = nums.length;
    if (size < 2) return;
    const offset = k % size;
    for (let i = 0; i < offset; i++) {
        // 外层循环记录移动趟数
        // 内层循环数组群移
        let temp = nums[size - 1];
        for (let j = size - 1; j > 0; j--) {
            nums[j] = nums[j - 1];
        }
        nums[0] = temp;
    }
};

/** 解法二：倒序法
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate2 = function(nums, k) {
    const size = nums.length;
    if (size < 2) return;
    const offset = k % size;
    nums.reverse(); // 1. 反转整个数组
    reversePartial(nums, 0, offset - 1); // 2. 反转左半部分数组
    reversePartial(nums, offset, size - 1); // 2. 反转右半部分数组
};

// 反转数组中指定区间的元素
const reversePartial = (arr, start, end) => {
    while (start < end) {
        [arr[start], arr[end]] = [arr[end], arr[start]];
        start++;
        end--;
    }
};

module.exports = { rotate, rotate2 };
