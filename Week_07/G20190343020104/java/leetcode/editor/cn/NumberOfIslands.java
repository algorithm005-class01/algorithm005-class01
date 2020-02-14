//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
//网格的四个边均被水包围。 
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


package leetcode.editor.cn;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
        char[][] grid = new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}};
        System.out.println(solution.numIslands(grid));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int dx[] = new int[]{-1, 1, 0, 0};
        int dy[] = new int[]{0, 0, -1, 1};
        char[][] g;

        public int numIslands(char[][] grid) {
            int isLands = 0;
            g = grid;
            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < g[i].length; j++) {
                    if (g[i][j] == '0') {
                        continue;
                    }
                    isLands += sink(i, j);
                }
            }
            return isLands;
        }

        /**
         * 深度优先搜索，如果是1的话，将它相邻的1全部打为0
         *
         * @param i
         * @param j
         * @return
         */
        int sink(int i, int j) {
            if (g[i][j] == '0') {
                return 0;
            }
            g[i][j] = '0';
            for (int k = 0; k < dx.length; k++) {
                int x = i + dx[k], y = j + dy[k];
                if (x >= 0 && x < g.length && y >= 0 && y < g[i].length) {
                    if (g[x][y] == '0') continue;
                    sink(x, y);
                }
            }
            return 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}