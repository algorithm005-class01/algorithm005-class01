/*
 * @lc app=leetcode.cn id=46 lang=javascript
 *
 * [46] 全排列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
 let ans = []   
 let visited = new Array(nums.length).fill(0)
 dfs(nums,ans,[],visited)
 return ans
};
let dfs = (nums,ans,cur,visited) => {
  if(cur.length == nums.length) {
    ans.push(cur.slice())
  }
  for(let i = 0; i < nums.length; i++) {
    if(visited[i] != 0) {
      continue
    }
    cur.push(nums[i])
    visited[i] = 1
    dfs(nums,ans,cur,visited)
    cur.pop()
    visited[i] = 0
  }
}
// @lc code=end

