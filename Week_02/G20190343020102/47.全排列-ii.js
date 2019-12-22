/*
 * @lc app=leetcode.cn id=47 lang=javascript
 *
 * [47] 全排列 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
  let ans = []   
  let visited = new Array(nums.length).fill(0)
  nums.sort((a,b) => a - b)
  console.log(nums)
  dfs(nums,ans,[],visited)
  return ans
};
let dfs = (nums,ans,cur,visited) => {
  if(cur.length == nums.length) {
    ans.push(cur.slice())
  }
  for(let i = 0; i < nums.length; i++) {
    if (visited[i] == 1 || (i > 0 && visited[i - 1] == 0 && nums[i - 1] == nums[i])) continue;
    cur.push(nums[i])
    visited[i] = 1
    dfs(nums,ans,cur,visited)
    cur.pop()
    visited[i] = 0
  }
}
// @lc code=end

