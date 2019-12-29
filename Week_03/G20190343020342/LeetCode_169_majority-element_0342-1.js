// 解法一：暴力求解
// 时间复杂度 O(n^2)
// 空间复杂度 O(1)

// 暴力算法第一层遍历整个数组，第二层遍历余下元素计数

var majorityElement = function(nums) {
    if (nums.length === 1) return nums[0];
    for (let i = 0, len = nums.length; i < len; i++) {
        let count = 1;
        for (let j = i + 1; j < len; j++) {
            if (nums[i] === nums[j]) count++;
            if (count > len / 2) return nums[i];
        }
    }
};