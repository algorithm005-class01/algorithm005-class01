class Solution {
private:
    void sink(vector<vector<char>>& grid,int r,int c){

        int nr=grid.size();
        int nc=grid[0].size();
        //flood fill 一定要把岛屿击沉
        grid[r][c] = 0;
        if(r - 1 >= 0 && grid[r-1][c] == '1') sink(grid,r - 1,c);
        if(r + 1 < nr && grid[r+1][c] == '1') sink(grid,r + 1,c);
        if(c - 1 >= 0 && grid[r][c-1] == '1') sink(grid,r,c - 1);
        if(c + 1 < nc && grid[r][c+1] == '1') sink(grid,r,c + 1);
    }
public:
    int numIslands(vector<vector<char>>& grid) {
        if(grid.size() == 0)
            return 0;
        int numR=grid.size();
        int numC=grid[0].size();
        int landCount = 0;
        for(int r=0;r<numR;r++)
        {
            for(int c=0;c<numC;c++)
            {
                if(grid[r][c] == '1')
                {
                    ++landCount;
                    sink(grid,r,c);
                }
            }
        }
        return landCount;
    }
};
