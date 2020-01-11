/**
 * @param {character[][]} grid
 * @return {number}
 */
// DFS
var numIslands = function(grid) {
  // 排除空数据的情况
  if (!grid || grid.length == 0) return 0;

  // 长度
  var nr = grid.length;
  // 宽度
  var nc = grid[0].length;
  // 岛屿数量
  var res = 0;

  // 按长度遍历
  for (var r = 0; r < nr; r++) {
    // 按宽度遍历
    for (var c = 0; c < nc; c++) {
      // 发现岛屿
      if (grid[r][c] === '1') {
        // 岛屿数量+1
        res++;
        // 将已发现的岛屿从地图删除
        grid[r][c] = '0';

        // 相邻岛屿
        var nei = [];
        nei.push([r, c]);

        // 开始 dfs
        while (nei.length) {
          var id = nei.pop();

          // 检查左侧
          if (grid[id[0]-1] && grid[id[0]-1][id[1]] == '1') {
            nei.push([id[0]-1, id[1]]);
            grid[id[0]-1][id[1]] = '0';
          }

          // 检查右侧
          if (grid[id[0]+1] && grid[id[0]+1][id[1]] == '1') {
            nei.push([id[0]+1, id[1]]);
            grid[id[0]+1][id[1]] = '0';
          }

          // 检查上方
          if (grid[id[0]] && grid[id[0]][id[1]-1] == '1') {
            nei.push([id[0], id[1]-1]);
            grid[id[0]][id[1]-1] = '0';
          }

          // 检查下方
          if (grid[id[0]] && grid[id[0]][id[1]+1] == '1') {
            nei.push([id[0], id[1]+1]);
            grid[id[0]][id[1]+1] = '0';
          }
        }
      }
    }
  }

  return res;
};
