/*
 * @lc app=leetcode.cn id=283 lang=javascript
 *
 * [283] 移动零
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */

var moveZeroes = function(nums) {
    //第1遍.自己的解法 , O(1)
    //遍历一遍，记录第一个0(firstZero)的位置，遇到非0，跟firstZero换位置
    let firstZero = -1;
    for (let i = 0; i < nums.length; i++) {
        //找到首0
        if (nums[i] == 0 && firstZero == -1) {
            firstZero = i;
        }
        //遇到非0且找到首0，开始替换
        if (nums[i] != 0 && firstZero != -1) {
            nums[firstZero++] = nums[i];
            nums[i] = 0;
        }
    }
    return nums;
}; 

/********************解法1 end */

//二. 网上的解法
//1. 遍历，找第一个0 insertPos，且遇到非0值，将0替换insertPos
//2. 在第一个0的位置 insertPos 后面再补上长度为(nums.length - insertPos)个0
// 时间复杂度为O(n)
/* var moveZeroes = function (nums) {

    let insertPos = 0;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            nums[insertPos++] = nums[i];
        }
    }
    while (insertPos < nums.length) {
        nums[insertPos++] = 0;
    }
};
/********************解法2 end */

/**解法3，滚雪球， */
/* var moveZeroes = function(nums){
    let snowBallSize = 0;

    for(let i = 0; i < nums.length; i++){
        if(nums[i] == 0){
            snowBallSize++;
        }
        else if(snowBallSize > 0){
            nums[i - snowBallSize] = nums[i];
            nums[i] = 0;
        }
    }
} */
// @lc code=end