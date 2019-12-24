/*
 * @lc app=leetcode.cn id=77 lang=javascript
 *
 * [77] 组合
 */

// @lc code=start
/**
 * @param {number} n
 * @param {number} k
 * @return {number[][]}
 */
var combine = function(n, k) {
  let ans = [], count = 0
  dfs(n, k, 1, ans,[])
  return ans
};
let dfs = (n,k,key,ans,cur) => {
  if(k == cur.length) {
    ans.push(cur.slice())
  }
  for(;key <= n; key++) {
    cur.push(key)
    dfs(n,k,key+1,ans,cur)
    cur.pop()
  }
}
// @lc code=end

