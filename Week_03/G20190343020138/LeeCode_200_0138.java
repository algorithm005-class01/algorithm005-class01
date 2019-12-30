package com.log8.week03;

//https://leetcode-cn.com/problems/number-of-islands/

public class Solution200 {

    int[] dx = new int[]{-1,1,0,0};
    int[] dy = new int[]{0,0,-1,1};
    char[][] g;
    //使用最基本的沉岛策略来解决
    public int numIslands(char[][] grid) {
        if(grid==null){
            return 0;
        }
        int result = 0;
        //1.0 循环每个元素判断是否为1
        //值为1 执行沉岛
        //值为0 continue
//        int col = grid[0].length;
//        int row = grid.length;
        for(int row=0;row<grid.length;row++){
            for (int col=0;col<grid[0].length;col++){
                if(grid[row][col]=='0') continue;
                result = result + sink(row,col);
            }
        }
        return result;
    }


    public int sink(int row,int col){
        //terminator
        if(this.g[row][col]==0){
            return 0;
        }

        //process current level
        this.g[row][col] = 0;

        //drill down
        for(int i = 0 ;i < dx.length ;  i++){
            int x = row + dx[i];
            int y = col + dy[i];
            if(x>=0&&x<this.g.length&&y>=0&&y<this.g[x].length){
                if(this.g[x][y]=='0') continue;
                sink(x,y);

            }
        }
        return 1;
    }

    public static void main(String[] args) {
//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}};

        Solution200 s200 = new Solution200();
//        s200.g = new char[][]{
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}};
        s200.g = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(s200.numIslands(s200.g));
    }
}
