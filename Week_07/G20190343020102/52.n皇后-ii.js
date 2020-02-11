/*
 * @lc app=leetcode.cn id=52 lang=javascript
 *
 * [52] N皇后 II
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var totalNQueens = function (n) {
  let ans = 0
  let dfs = (row, col, l, r) => {
    if (row == n) {
      ans++
      return
    }
    let bit = ((1 << n) - 1) & (~(col | r | l))
    while (bit > 0) {
      let p = bit & (-bit)
      bit = bit & (bit - 1)
      dfs(row + 1, col | p, (p | l) << 1, (p | r) >> 1)
    }
  }
  dfs(0, 0, 0, 0)
  return ans
};
// @lc code=end


