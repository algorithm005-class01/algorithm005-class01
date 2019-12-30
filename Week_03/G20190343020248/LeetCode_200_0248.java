/**
 * 岛屿数量问题
 * 可以将二维网格看成一个无向图，竖直或水平相邻的 1 之间有边。
 * <p>
 * 扫描整个二维网格，如果一个结点包含 1，则以其为根结点启动深度优先搜索。
 * 在深度优先搜索过程中，每个访问过的结点被标记为 0
 * 计数启动深度优先搜索的根结点的数量，即为岛屿的数量。
 */
public class LeetCode_200_0248 {

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
}