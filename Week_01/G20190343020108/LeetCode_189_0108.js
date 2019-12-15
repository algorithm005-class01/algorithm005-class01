/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
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
