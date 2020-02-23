class Solution {
    private int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    private int m,n;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int level = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    level++;
                }
            }
        }
        return level;
    }
    public void dfs(char[][] grid,int row,int col){
        if(row<0||row>=m||col<0||col>=n||grid[row][col]=='0'){
            return;
        }
        grid[row][col]='0';
        for(int[] d:directions){
            dfs(grid,row+d[0],col+d[1]);
        }
    }
}
