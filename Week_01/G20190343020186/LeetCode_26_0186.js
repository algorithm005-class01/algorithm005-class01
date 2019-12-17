//LeetCode_26_0186.js
var removeDuplicates = function(nums) {
    let len = nums.length
    let i = 0
    let j = i + 1

    for (;i < nums.length;) {
        if (j < nums.length && nums[i] === nums[j] ) { // 继续深入遍历j
          j++
        } else { // 如果不等于
           if (j - i > 1) {
             nums.splice(i+1, j-i-1)
             i++
             j = i+1
           } else {
             i++
             j++  
           }
        }
    }
    
    return nums.length
};