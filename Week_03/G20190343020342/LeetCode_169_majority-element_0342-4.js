// Boyer-Moore 投票算法
// 时间复杂度：O(n)
// 空间复杂度：O(1) 

// 少数服从多数

var majorityElement = function(nums) {
    let count = 0;
    let candidate = null;

    nums.forEach(num => {
        if (count == 0) {
            candidate = num;
        }
        count += (num === candidate) ? 1 : -1;
    });

    return candidate;
}

