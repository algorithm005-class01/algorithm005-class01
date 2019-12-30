/*
 * @lc app=leetcode.cn id=74 lang=javascript
 *
 * [74] 搜索二维矩阵
 */

// @lc code=start
/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function (matrix, target) {
  let m = matrix.length;
  if (m == 0) return false;
  let n = matrix[0].length;

  // 二分查找
  let left = 0, right = m * n - 1;
  let pivotIdx, pivotElement;
  while (left <= right) {
    pivotIdx = (left + right) >> 1;
    pivotElement = matrix[parseInt(pivotIdx / n)][pivotIdx % n];
    if (target == pivotElement) return true;
    else {
      if (target < pivotElement) right = pivotIdx - 1;
      else left = pivotIdx + 1;
    }
  }
  return false;
};
// @lc code=end

