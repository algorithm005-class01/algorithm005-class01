# 200.岛屿数量
## 思路
- 深度优先搜索
- 广度优先搜索

## 题解
### DFS
```c
class Solution {
private:
    int m,n;
    int directionx[4] = {1,0,-1,0};
    int directiony[4] = {0,1,0,-1};

public:

    int numIslands(vector<vector<char> >& grid) {
        int res = 0;
        this->m = grid.size();
        if(m==0)
            return 0;
        this->n = grid[0].size();
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    void dfs(vector<vector<char> >& grid, int row, int col){
        //先判定边界
        if(row<0 || row>=m || col<0 || col>=n )
            return;
        if(grid[row][col]=='0')
            return;
        for(int i = 0 ; i < 4 ; i++){
            grid[row][col] = '0';
            dfs(grid, row+directionx[i], col+directiony[i]);
        }
    }
};
```
题目中的坑，用vector来读取二维数组的size的时候通常使用一下方法
```c
    this->m = grid.size();
    this->n = grid[0].size();
```
这就涉及到一个问题，当输入的二维数组是空的时候是获取不到grid[0]的所以会报错，所以这题要对二维数组进行单独的判断。