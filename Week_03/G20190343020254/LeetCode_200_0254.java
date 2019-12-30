package com.ilearning.myapplication;

class Solution {
    int totalCol, totalRow;
    int number = 0;
    boolean is1 = false;

    public   int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        totalRow = grid.length;
        totalCol = grid[0].length;

        for (int i = 0; i < totalRow; i++) {
            for (int j = 0; j < totalCol; j++) {
                checkNext(grid, i, j);
                if(is1) {
                    number++;
                    is1 = false;
                }
            }
        }

        return number;
    }

    // 遍历区域为1的地方，并将1变为0
    public   void checkNext(char[][] grid, int curRow,int curCol) {
        if (curCol < 0
                || curCol > totalCol - 1
                || curRow < 0
                || curRow > totalRow - 1
                || grid[curRow][curCol] == '0') {
            return;
        }

        char v = grid[curRow][curCol];

        if (v == '1') {
            grid[curRow][curCol] = '0';
            is1 = true;
        }

        // 当前节点的上下左右
        checkNext(grid, curRow+1, curCol);
        checkNext(grid, curRow-1, curCol);
        checkNext(grid, curRow, curCol-1);
        checkNext(grid, curRow, curCol+1);
    }
}