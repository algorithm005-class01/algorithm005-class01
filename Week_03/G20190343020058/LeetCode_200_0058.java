class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                islands += sink(grid, i, j);
        return islands;
    }

    int sink(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] == '0')
            return 0;
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++)
            sink(grid, i + d[k], j + d[k + 1]);
        return 1;
    }

    int[] d = { 0, 1, 0, -1, 0 };
}