/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    /**
     * 根据题解自己理解了下思路写的
     * 首先是要创建等大的二维数组用来标记是否已访问过
     * 然后遍历数组，只要有未访问过的并且是1的位置，便从这个位置开始找相邻的未访问过的为1的位置（这里要注意边界条件，不要越界）
     * 访问过的位置都会标记
     * 使用的递归用到了回溯，访问的位置无法再向其他位置走之后，会回到上一个相邻的位置，知道所有相邻的位置都被访问一遍
     */

    private int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int numIslands(char[][] grid) {
        int rows = grid.length;

        if (rows == 0) {
            return 0;
        }
        int cols = grid[0].length;

        boolean[][] marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, marked, grid);
                }
            }
        }
        return count;

    }

    private void dfs(int x, int y, boolean[][] marked, char[][] grid) {
        marked[x][y] = true;
        for (int k = 0; k < 4; k++) {
            int newX = x + direction[k][0];
            int newY = y + direction[k][1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
                    && !marked[newX][newY] && grid[newX][newY] == '1') {
                dfs(newX, newY, marked, grid);
            }
        }
    }
}