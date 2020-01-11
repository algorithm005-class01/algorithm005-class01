/*
 * @lc app=leetcode.cn id=17 lang=javascript
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
  let hashMap = [
    ['a','b','c'],
    ['d','e','f'],
    ['g','h','i'],
    ['j','k','l'],
    ['m','n','o'],
    ['p','q','r','s'],
    ['t','u','v'],
    ['w','x','y','z']
  ]
  let ans = []
  recursion(ans,hashMap,digits,0,'')
  return ans
};
let recursion = (ans,hashMap,str,pos,val) => {
  if(pos === str.length) {
    if(val !== '')
    ans.push(val)
    return
  }
  let strArr = hashMap[parseInt(str[pos]) - 2]
  for(let i = 0; i < strArr.length; i++) {
    recursion(ans,hashMap,str,pos + 1, val+strArr[i])
  }
}
// @lc code=end

