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



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        UnionFind uf = new UnionFind(grid.length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;

    }

    class UnionFind {
        private int[] parents;
        private int count;
        public UnionFind (int n) {
            count = n;
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public int find (int p) {
            while (parents[p]!=p) {
                parents[p] = parents[parents[p]];
                p = parents[p];
            }
            return p;
        }

        public void union (int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP!=rootQ) {
                parents[rootP] = rootQ;
                count--;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
