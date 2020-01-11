/*
 * @lc app=leetcode.cn id=200 lang=javascript
 *
 * [200] 岛屿数量
 */

// @lc code=start
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function (grid) {
  let count = 0
  for(let i = 0; i < grid.length; i++) {
    for(let j = 0; j < grid[0].length; j++){
      if(grid[i][j] == 1) {
        count++
        water(grid, i, j)
        // console.log(grid)
      }
    }
  }
 
  return count
};

let water = (grid,x,y) => {
  let queue = []
  dx = [-1, 1, 0, 0]
  dy = [0, 0, -1, 1]
  queue.push({x,y})
  grid[x][y] = 0
  while(queue.length > 0) {
    let temp = queue[0]
    queue.shift()
    for(let i = 0; i < dx.length; i++) {
      let a = temp['x'] + dx[i], b = temp['y'] + dy[i]
      if(a >= 0 && a < grid.length && b >= 0 && b < grid[0].length && grid[a][b] == 1) {
        grid[a][b] = 0
        queue.push({x:a,y:b})
      }
    }
  }
}
// @lc code=end

