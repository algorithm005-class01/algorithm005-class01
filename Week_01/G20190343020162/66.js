// https://leetcode-cn.com/problems/plus-one/

// 先最后一个加1，如果不需要进位直接得出结果
// 如果需要进位，需要再遍历一遍，如果数字为10的话，进一位
var plusOne = function(digits) {
    let lastIndex = digits.length - 1
    if(digits[lastIndex] + 1<10) {
        digits[lastIndex] = digits[lastIndex] + 1
    }
     else {
           digits[lastIndex] = digits[lastIndex] + 1
    for(let i =digits.length; i>=0 ; i--) {
        if(digits[i]===10) {
      digits[i] = 0
      if(i>0) {
          digits[i-1] +=1 
      } else if(i==0) {
         digits.unshift(1)
      }
     }
    }
    console.log(digits)
    }
 
    return digits
 };