/*
 * @lc app=leetcode.cn id=51 lang=javascript
 *
 * [51] N皇后
 */

// @lc code=start
/**
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
  let ans = [],  currAns = []  
  recursion(ans,currAns,n,0)
  return generateArray(ans,n)
};
let recursion = (ans, currAns, n, level) => {
  if(level == n) {
    ans.push(currAns.slice())
    return
  }
  //考虑竖着一列，左右对角线即可
  for(let i = 0; i < n; i++) {
    let flag = false
    for(let j = 0; j < currAns.length; j++) {
      // (i,level) (currAns[j],j)
      let k = (j - level) / (currAns[j] - i)
      if(i == currAns[j] || k == 1 || k == -1) {
        flag = true
        break
      }
    }
    if(flag) continue
    currAns.push(i)
    recursion(ans,currAns,n,level + 1)
    currAns.pop(i)
  }
}
let generateArray = (arr,n) => {
  let ans = []
  let tempAns =[]
  for(let i = 0; i < arr.length; i++) {
    tempAns = []
    for(let j = 0; j < n; j++) {
      let str = ''
      for(let k = 0; k < n; k++) {
        if(arr[i][j] == k) {
          str += 'Q'
        } else {
          str += '.'
        }
      }
      tempAns.push(str)
    }
    ans.push(tempAns)
  }
  return ans
}
// @lc code=end




