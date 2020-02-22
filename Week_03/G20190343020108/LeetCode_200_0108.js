/**
 * Floodfill (DFS) 优化方向向量表示
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    if (!grid || grid.length == 0) return 0;
    let m = grid.length;
    let n = grid[0].length;
    let island = 0; // count the number of islands
    // 方向向量
    const dx = [-1, 1, 0, 0];
    const dy = [0, 0, -1, 1];
    /**
     * DFS 以 (i, j) 为 root node 分别向上下左右四个方向沉岛
     * @param {number} i
     * @param {number} j
     * @return {number} 发现岛屿返回1，否则返回0
     */
    function sink(i, j) {
        // 未发现岛屿，直接返回
        if (grid[i][j] == '0') return 0;
        // 发现岛屿，将当前岛屿沉没
        grid[i][j] = '0';
        // 检查与当前岛屿连通的四个方向，如发现岛屿，沉没
        for (let k = 0; k < dx.length; k++) {
            let x = i + dx[k];
            let y = j + dy[k];
            if (x >= 0 && x < m && y >= 0 && y < n)
                if (grid[x][y] == '1') sink(x, y);
        }
        // 所有岛屿和与其连通的岛屿都沉没完成，返回岛屿个数
        return 1;
    }
    // 遍历处理每个格子
    for (let i = 0; i < m; i++)
        for (let j = 0; j < n; j++) if (grid[i][j] == '1') island += sink(i, j);

    return island;
};

/**
 * Floodfill (BFS)
 * @param {character[][]} grid
 * @return {number}
 */
// var numIslands = function(grid) {
//     if (!grid || grid.length == 0) return 0;
//     let m = grid.length;
//     let n = grid[0].length;
//     let islands = 0;
//     const queue = [];
//     const dx = [-1, 1, 0, 0];
//     const dy = [0, 0, -1, 1];
//     /**
//      * BFS 以 (i, j) 为 root node 分别向上下左右四个方向沉岛
//      * @param {number} i
//      * @param {number} j
//      * @return {number} 发现岛屿返回1，否则返回0
//      */
//     function sink(i, j) {
//         if (grid[i][j] == '0') return 0;
//         grid[i][j] = '0';
//         for (let k = 0; k < dx.length; k++) {
//             let x = i + dx[k];
//             let y = j + dy[k];
//             if (x >= 0 && x < m && y >= 0 && y < n)
//                 if (grid[x][y] == '1') queue.push([x, y]);
//         }
//         return 1;
//     }

//     for (let i = 0; i < m; i++)
//         for (let j = 0; j < n; j++) {
//             if (grid[i][j] == '1') {
//                 islands++;
//                 queue.push([i, j]);
//                 while (queue.length > 0) {
//                     let cell = queue.shift();
//                     sink(cell[0], cell[1]);
//                 }
//             }
//         }

//     return islands;
// };
