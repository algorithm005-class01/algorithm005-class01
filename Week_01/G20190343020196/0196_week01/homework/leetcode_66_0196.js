/*
 * @lc app=leetcode.cn id=66 lang=javascript
 *
 * [66] 加一
 */

// @lc code=start
/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    let len = digits.length;

 
    for(let i = len - 1; i >= 0; i--){
        
/*         if(digits[i] != 9){    
            digits[i]++;
            break;
        }else{   // ==9 ,进1
            digits[i] = 0;
        } */
        
        //网上优化， 用求余考虑
        digits[i]++;
        digits[i] %= 10;
        if(digits[i]!=0)
            return digits;
        
    }

    //首位为0，需补位
    if(digits[0] == 0){
        digits = [1, ...digits];
        console.log(digits);
    }
    return digits;

};
// @lc code=end

console.log(plusOne([9]));
