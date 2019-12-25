/**
 * https://leetcode-cn.com/problems/n-queens/
 * 
 * @param {number} n
 * @return {string[][]}
 */
var solveNQueens = function(n) {
  var board = Array.from({ length: n }, () => Array.from({ length: n }, () => '.'));
  var col = Array.from({ length: n }, () => false);
  var diagLeft = Array.from({ length: 2 * n - 1 }, () => false);
  var diagRight = Array.from({ length: 2 * n - 1 }, () => false);
  var res = [];

  function backtrack (i) {
    if (i === n) {
      res.push(board.map(row => row.join('')));
      return;
    }

    for (var j = 0; j < n; ++j) {
      var l = i + j;
      var r = j - i + n - 1;

      if (!col[j] && !diagLeft[l] && !diagRight[r]) {
        col[j] = diagLeft[l] = diagRight[r] = true;
        board[i][j] = 'Q';
        backtrack(i + 1);

        col[j] = diagLeft[l] = diagRight[r] = false;
        board[i][j] = '.';
      }
    }
  }

  backtrack(0);
  return res;
};