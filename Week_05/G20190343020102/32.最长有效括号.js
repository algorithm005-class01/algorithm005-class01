/*
 * @lc app=leetcode.cn id=32 lang=javascript
 *
 * [32] 最长有效括号
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var longestValidParentheses = function(s) {
  if(s.length == 0) return 0
  var temp = [{type: 0, index: 0}]
  max = 0
  num = 0
  for(i=0;i<s.length;i++){
      if(s[i] == '(') temp.push({type: '(', index: i+1})
      else if(s[i] == ')' && temp[temp.length-1].type == '(') temp.pop()
      else temp.push({type: ')', index: i+1})
  }
  temp.push({type: 0, index: s.length+1})
  for(j=0;j<temp.length-1;j++){
      num = temp[j+1].index - temp[j].index - 1
      if (num>max) max = num
  }
  return max
};
// @lc code=end

