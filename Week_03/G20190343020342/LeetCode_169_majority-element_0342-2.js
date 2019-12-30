// 哈希表
// 时间复杂度：O(n)
// 空间复杂度：O(n)
// 用哈希表来快速统计每个元素出现的次数


var majorityElement = function(nums) {
    if (nums.length === 1) return nums[0];
    let map = {},result;
    for (let i = 0,len = nums.length; i < len; i++){
        if (map[nums[i]]) {
            map[nums[i]]++;
            if (map[nums[i]] > len / 2) {
                result = nums[i];
            }
        } else {
            map[nums[i]] = 1;
        }
    }
    return result;  
};

