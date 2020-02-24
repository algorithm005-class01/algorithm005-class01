class Solution {
public:
    void bfs(vector<vector<char>>& grid,int i,int j){
        if(i < 0 || j < 0 || i >= grid.size() || j >= grid[0].size()) return;
        if(grid[i][j] == '0')return;
        grid[i][j] = '0';
        bfs(grid,i+1,j);
        bfs(grid,i,j+1);
        bfs(grid,i-1,j);
        bfs(grid,i,j-1);
    }
    int numIslands(vector<vector<char>>& grid) {
        int ans = 0;
        for(int i = 0;i < grid.size(); i++){
            for(int j = 0;j< grid[0].size(); j++){
                if(grid[i][j] == '0') continue;
                ans++;
                bfs(grid, i, j);
            }
        }
        return ans;
    }
};