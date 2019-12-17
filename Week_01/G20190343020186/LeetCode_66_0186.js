var plusOne = function(digits) {
    let len  = digits.length
    let sum = 0
    for (i = len - 1; i >=0;i--) {
       sum = digits[i] + 1
       if (sum == 10) {
         digits[i] = 0
         if (i === 0) {
           let arr = [1]  
           for (let i = 0; i < len; i ++) {
             arr.push(0)
           }
           return arr
         }
         continue
       } else {
         digits[i] = sum
         break
       }
    }

    return digits
};