// 排序
// 时间复杂度：O(nlogn)
// 空间复杂度：O(1) 或者 O(n)

var majorityElement = function(nums) {
    nums.sort();
    return nums[parseInt(nums.length / 2)];
}

