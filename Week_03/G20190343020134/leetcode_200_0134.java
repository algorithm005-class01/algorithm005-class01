package sort.day1;
//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
//
// 示例 1:
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
//
//
// 示例 2:
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
//
// Related Topics 深度优先搜索 广度优先搜索 并查集

/**
 * 解题思路：
 * 深度优先搜索（沉岛策略）：
 * 当遇到某个为1时，则把当前的元素的值设置为0，并把其上下左右的所有为1的元素都设置为0，同时岛屿的数量加1。
 */

public class NumberOfIslands200 {
    private static int[] dx = {-1,1,0,0};
    private static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                islands += sink(grid, i, j);
            }
        }
        return islands;
    }

    private static int sink(char[][] grid, int i, int j) {
        if (grid[i][j] == '0') {
            return 0;
        }
        //sink
        grid[i][j] = '0';

        for (int k =0; k < dx.length;k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[i].length) {
                if (grid[x][y] == '0') {
                    continue;
                }
                sink(grid,x,y);
            }
        }
        return 1;
    }
}
