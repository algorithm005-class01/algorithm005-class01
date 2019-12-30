/*
 * @lc app=leetcode.cn id=860 lang=javascript
 *
 * [860] 柠檬水找零
 */

// @lc code=start
/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function (bills) {
  let c1 = c2 = c3 =0, flag = true
  for(let i = 0 ; i < bills.length; i++){
    switch(bills[i]) {
      case 5:c1++;break;
      case 10:c2++; c1--; break;
      case 20:c3++;
        if(c2 == 0) {
          c1 -= 3;
        } else {
          c1--
          c2--
        }
      break;
      default :break;
    }
    if(c1 < 0 || c2 <0) {
      flag = false
      break
    }
  }
  return flag
};
// @lc code=end

