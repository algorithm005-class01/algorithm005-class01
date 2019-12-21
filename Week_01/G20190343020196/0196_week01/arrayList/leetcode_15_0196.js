/*
 * @lc app=leetcode.cn id=15 lang=javascript
 *
 * [15] 三数之和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */

 //1. 暴力求解：三重循环O(n^3)
 //2. hash表 来记录 a, b, a+b =-c
 //3. 双指针左右下标夹逼

//解法：
//1.先排序


var twoSum = function(nums, target) {

    //1.先排序 
    nums.sort((a, b)=> {
        return a - b;
    });

    let res = new Array();

    for(let k = 0; k < nums.length - 2; k++){ // 最外层
        //1.遍历负数， 具有负数才能让3数相加为0
        //已排过序，3个数都大于0，直接break
        if(nums[k] > 0) break;
    
        //2.将重复的nums[k]跳过
        if(k > 0 && nums[k] == nums[k - 1]) continue;

        //3.双指针左右夹逼 
        let i = k+1;  
        let j = nums.length -1;

        while(i < j){
            let sum = nums[k] + nums[i] + nums[j];
            if(sum < 0){ //当s < 0时，i += 1并跳过所有重复的nums[i]；
                while(i < j && nums[i] == nums[++i]);
            } else if (sum > 0) { //当s > 0时，j -= 1并跳过所有重复的nums[j]；
                while(i < j && nums[j] == nums[--j]);
            } else { //当s == 0时，记录组合[k, i, j]至res，执行i += 1和j -= 1并跳过所有重复的nums[i]和nums[j]，防止记录到重复组合。
                res.push([nums[k], nums[i], nums[j]]);
                while(i < j && nums[i] == nums[++i]);
                while(i < j && nums[j] == nums[--j]);
            }
        }
    }
    return res;
};
// @lc code=end

